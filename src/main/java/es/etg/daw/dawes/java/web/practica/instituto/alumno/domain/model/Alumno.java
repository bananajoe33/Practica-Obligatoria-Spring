package es.etg.daw.dawes.java.web.practica.instituto.alumno.domain.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Alumno {

    private AlumnoId id;
    private String nombre;
    private String apellido;
    private int edad;
    private LocalDateTime createdAt;
    private GrupoId grupo;
}
