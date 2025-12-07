package es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.etg.daw.dawes.java.web.practica.instituto.alumno.application.service.alumno.CreateAlumnoService;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.application.service.alumno.DeleteAlumnoService;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.application.service.alumno.EditAlumnoService;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.application.service.alumno.FindAlumnoService;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.application.usecase.alumno.CreateAlumnoUseCase;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.application.usecase.alumno.DeleteAlumnoUseCase;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.application.usecase.alumno.EditAlumnoUseCase;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.application.usecase.alumno.FindAlumnoUseCase;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.domain.repository.AlumnoRepository;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.db.jpa.repository.AlumnoEntityJpaRepository;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.db.jpa.repository.AlumnoJpaRepositoryImpl;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class AlumnoConfig {

    private final AlumnoEntityJpaRepository alumnoEntityRepository;

    @Bean
    public AlumnoRepository alumnoRepository() {
        return new AlumnoJpaRepositoryImpl(alumnoEntityRepository);
    }

    @Bean
    public CreateAlumnoUseCase createAlumnoUseCase(AlumnoRepository alumnoRepository) {
        return new CreateAlumnoUseCase(alumnoRepository);
    }

    @Bean
    public FindAlumnoUseCase findAlumnoUseCase(AlumnoRepository alumnoRepository) {
        return new FindAlumnoUseCase(alumnoRepository);
    }

    @Bean
    public DeleteAlumnoUseCase deleteAlumnoUseCase(AlumnoRepository alumnoRepository) {
        return new DeleteAlumnoUseCase(alumnoRepository);
    }

    @Bean
    public EditAlumnoUseCase editAlumnoUseCase(AlumnoRepository alumnoRepository) {
        return new EditAlumnoUseCase(alumnoRepository);
    }

    @Bean
    public CreateAlumnoService createAlumnoService(CreateAlumnoUseCase createAlumnoUseCase) {
        return new CreateAlumnoService(createAlumnoUseCase);
    }

    @Bean
    public FindAlumnoService findAlumnoService(FindAlumnoUseCase findAlumnoUseCase) {
        return new FindAlumnoService(findAlumnoUseCase);
    }

    @Bean
    public DeleteAlumnoService deleteAlumnoService(DeleteAlumnoUseCase deleteAlumnoUseCase) {
        return new DeleteAlumnoService(deleteAlumnoUseCase);
    }

    @Bean
    public EditAlumnoService editAlumnoService(EditAlumnoUseCase editAlumnoUseCase) {
        return new EditAlumnoService(editAlumnoUseCase);
    }
}
