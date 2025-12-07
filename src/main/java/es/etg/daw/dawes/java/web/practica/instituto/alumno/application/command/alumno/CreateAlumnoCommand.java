package es.etg.daw.dawes.java.web.practica.instituto.alumno.application.command.alumno;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public class CreateAlumnoCommand {

    private String nombre;
    private String apellido;
    private int edad;
}
