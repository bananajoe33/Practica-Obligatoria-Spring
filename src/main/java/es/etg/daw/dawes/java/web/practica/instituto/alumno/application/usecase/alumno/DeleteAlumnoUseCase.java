package es.etg.daw.dawes.java.web.practica.instituto.alumno.application.usecase.alumno;

import es.etg.daw.dawes.java.web.practica.instituto.alumno.domain.model.AlumnoId;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.domain.repository.AlumnoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteAlumnoUseCase {

    private final AlumnoRepository alumnoRepository;

    public void delete(AlumnoId id) {
        alumnoRepository.deleteById(id);
    }
}
