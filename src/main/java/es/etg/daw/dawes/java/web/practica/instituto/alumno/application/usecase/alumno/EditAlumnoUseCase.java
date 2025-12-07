package es.etg.daw.dawes.java.web.practica.instituto.alumno.application.usecase.alumno;

import es.etg.daw.dawes.java.web.practica.instituto.alumno.application.command.alumno.EditAlumnoCommand;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.domain.error.AlumnoNotFoundException;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.domain.model.Alumno;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.domain.repository.AlumnoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EditAlumnoUseCase {

    private final AlumnoRepository alumnoRepository;

    public Alumno update(EditAlumnoCommand command) {
        return alumnoRepository.getById(command.id())
                .map(a -> {
                    a.setNombre(command.nombre());
                    a.setApellido(command.apellido());
                    a.setEdad(command.edad());
                    a.setGrupo(command.grupoId());
                    return alumnoRepository.save(a);
                })
                .orElseThrow(() -> new AlumnoNotFoundException(command.id().getValue()));
    }
}
