package es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.web.dto;

import java.time.LocalDateTime;

public record AlumnoResponse(
        int id,
        String nombre,
        String apellido,
        int edad,
        LocalDateTime createdAt,
        int grupoId
        ) {

}
