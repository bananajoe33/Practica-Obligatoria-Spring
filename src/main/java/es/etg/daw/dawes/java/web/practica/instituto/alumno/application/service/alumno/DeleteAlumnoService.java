package es.etg.daw.dawes.java.web.practica.instituto.alumno.application.service.alumno;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.web.practica.instituto.alumno.application.usecase.alumno.DeleteAlumnoUseCase;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.domain.model.AlumnoId;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DeleteAlumnoService extends AlumnoService {

    private final DeleteAlumnoUseCase deleteAlumnoUseCase;

    @CacheEvict
    @CachePut
    public void delete(AlumnoId id) {
        deleteAlumnoUseCase.delete(id);
    }
}
