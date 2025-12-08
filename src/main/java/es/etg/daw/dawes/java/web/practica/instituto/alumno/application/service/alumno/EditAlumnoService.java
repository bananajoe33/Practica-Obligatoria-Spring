package es.etg.daw.dawes.java.web.practica.instituto.alumno.application.service.alumno;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.web.practica.instituto.alumno.application.command.alumno.EditAlumnoCommand;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.application.usecase.alumno.EditAlumnoUseCase;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.domain.model.Alumno;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EditAlumnoService {

    private final EditAlumnoUseCase editAlumnoUseCase;

    public Alumno update(EditAlumnoCommand command) {
        return editAlumnoUseCase.update(command);
    }
}
