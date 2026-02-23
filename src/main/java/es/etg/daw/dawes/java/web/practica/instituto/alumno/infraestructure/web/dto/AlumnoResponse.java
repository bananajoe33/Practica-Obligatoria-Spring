package es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.web.dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

public record AlumnoResponse(

    @Schema(description = "ID único del alumno", example = "15")
    int id,

    @Schema(description = "Nombre del alumno", example = "Carlos")
    String nombre,

    @Schema(description = "Apellido del alumno", example = "García")
    String apellido,

    @Schema(description = "Edad del alumno", example = "18")
    int edad,

    @Schema(description = "Fecha y hora de creación del registro", example = "2024-05-20T14:30:00")
    LocalDateTime createdAt,

    @Schema(description = "ID del grupo al que pertenece el alumno", example = "3")
    int grupoId

) {
}