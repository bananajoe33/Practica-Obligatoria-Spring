package es.etg.daw.dawes.java.web.practica.instituto.alumno.application.usecase.alumno;

import java.util.List;

import es.etg.daw.dawes.java.web.practica.instituto.alumno.domain.error.AlumnoNotFoundException;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.domain.model.Alumno;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.domain.repository.AlumnoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindAlumnoUseCase {

    private final AlumnoRepository alumnoRepository;

    public List<Alumno> findAll() {
        List<Alumno> alumnos = alumnoRepository.getAll();

        if (alumnos.isEmpty())
            throw new AlumnoNotFoundException();

        return alumnos;
    }
}
