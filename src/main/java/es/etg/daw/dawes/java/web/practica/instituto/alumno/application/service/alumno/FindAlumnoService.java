package es.etg.daw.dawes.java.web.practica.instituto.alumno.application.service.alumno;

import java.util.List;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.web.practica.instituto.alumno.application.usecase.alumno.FindAlumnoUseCase;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.domain.model.Alumno;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FindAlumnoService {

    private final FindAlumnoUseCase findAlumnoUseCase;

    public List<Alumno> findAll() {
        return findAlumnoUseCase.findAll();
    }
}
