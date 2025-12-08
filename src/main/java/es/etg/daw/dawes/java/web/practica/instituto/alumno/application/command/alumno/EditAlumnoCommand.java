package es.etg.daw.dawes.java.web.practica.instituto.alumno.application.command.alumno;

import es.etg.daw.dawes.java.web.practica.instituto.alumno.domain.model.AlumnoId;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.domain.model.GrupoId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public class EditAlumnoCommand {

    private final AlumnoId id;
    private final String nombre;
    private final String apellido;
    private final int edad;
    private final GrupoId grupoId;
}

