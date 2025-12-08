package es.etg.daw.dawes.java.web.practica.instituto.alumno.application.command.alumno;

import es.etg.daw.dawes.java.web.practica.instituto.alumno.domain.model.GrupoId;

public record CreateAlumnoCommand(
        String nombre,
        String apellido,
        int edad,
        GrupoId grupoId
) {}
