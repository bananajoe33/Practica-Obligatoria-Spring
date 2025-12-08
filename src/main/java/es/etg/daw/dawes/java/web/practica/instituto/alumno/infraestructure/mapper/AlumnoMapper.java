package es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import es.etg.daw.dawes.java.web.practica.instituto.alumno.application.command.alumno.CreateAlumnoCommand;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.application.command.alumno.EditAlumnoCommand;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.domain.model.Alumno;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.domain.model.AlumnoId;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.domain.model.GrupoId;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.db.jpa.entity.AlumnoEntity;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.db.jpa.entity.GrupoEntity;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.web.dto.AlumnoRequest;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.web.dto.AlumnoResponse;

public class AlumnoMapper {

   public static CreateAlumnoCommand toCommand(AlumnoRequest req) {
    return new CreateAlumnoCommand(
            req.nombre(),
            req.apellido(),
            req.edad(),
            new GrupoId(req.grupoId())
    );
}



    public static EditAlumnoCommand toCommand(int id, AlumnoRequest alumnoRequest) {
        return new EditAlumnoCommand(
                new AlumnoId(id),
                alumnoRequest.nombre(),
                alumnoRequest.apellido(),
                alumnoRequest.edad(),
                new GrupoId(alumnoRequest.grupoId())
        );
    }

    public static AlumnoResponse toResponse(Alumno alumno) {
        return new AlumnoResponse(
                alumno.getId().getValue(),
                alumno.getNombre(),
                alumno.getApellido(),
                alumno.getEdad(),
                alumno.getCreatedAt(),
                alumno.getGrupo().getValue()
        );
    }

    public static AlumnoEntity toEntity(Alumno a) {
    GrupoEntity grupo = null;
    if (a.getGrupo() != null) {
        grupo = new GrupoEntity();
        grupo.setId(a.getGrupo().getValue());
    }
    
    AlumnoId id = a.getId();
    return AlumnoEntity.builder()
            .id(id != null ? id.getValue() : null)
            .nombre(a.getNombre())
            .apellido(a.getApellido())
            .edad(a.getEdad())
            .fechaCreacion(a.getCreatedAt() != null ? a.getCreatedAt() : LocalDateTime.now())
            .grupo(grupo) // Puede ser null
            .build();
}


    public static Alumno toDomain(AlumnoEntity a) {
        return Alumno.builder()
                .id(new AlumnoId(a.getId()))
                .nombre(a.getNombre())
                .apellido(a.getApellido())
                .edad(a.getEdad())
                .createdAt(a.getFechaCreacion())
                .grupo(new GrupoId(a.getGrupo().getId()))
                .build();
    }

    public static List<Alumno> toDomain(List<AlumnoEntity> lista) {
        List<Alumno> la = new ArrayList<>();
        for (AlumnoEntity ae : lista) {
            la.add(toDomain(ae));
        }
        return la;
    }
}
