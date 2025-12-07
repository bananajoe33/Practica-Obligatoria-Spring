package es.etg.daw.dawes.java.web.practica.instituto.alumno.application.usecase.alumno;

import java.time.LocalDateTime;

import es.etg.daw.dawes.java.web.practica.instituto.alumno.application.command.alumno.CreateAlumnoCommand;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.domain.model.Alumno;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.domain.repository.AlumnoRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateAlumnoUseCase {

    private AlumnoRepository alumnoRepository;

    public Alumno create(CreateAlumnoCommand comando) {

        Alumno alumno = Alumno.builder()
                .nombre(comando.nombre())
                .apellido(comando.apellido())
                .edad(comando.edad())
                .createdAt(LocalDateTime.now())
                .build();

        return alumnoRepository.save(alumno);
    }
}
