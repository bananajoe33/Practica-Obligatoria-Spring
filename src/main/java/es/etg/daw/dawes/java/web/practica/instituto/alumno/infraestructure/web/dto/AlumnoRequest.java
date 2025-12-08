package es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.web.dto;


import es.etg.daw.dawes.java.web.practica.instituto.alumno.domain.model.Alumno;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.web.validation.NombradoAlumno;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record AlumnoRequest(
        @NotBlank(message = "{alumno.valid.nombre.no_vacio}")
        @NombradoAlumno(message = "{alumno.valid.nombre.nombrado_validation}")
        String nombre,

        @NotBlank(message = "{alumno.valid.apellido.no_vacio}")
        @NombradoAlumno(message = "{alumno.valid.apellido.nombrado_validation}")
        String apellido,

        @Min(value = 0, message = "{alumno.valid.edad.min}")
        @Max(value = 120, message = "{alumno.valid.edad.max}")
        int edad,

        @Min(value = 1)
        int grupoId
) {

    public AlumnoRequest(Alumno a) {
        this(a.getNombre(), a.getApellido(), a.getEdad(), a.getGrupo().getValue());
    }
}

