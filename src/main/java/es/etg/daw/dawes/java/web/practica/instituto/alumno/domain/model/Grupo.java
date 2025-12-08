package es.etg.daw.dawes.java.web.practica.instituto.alumno.domain.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Grupo {
    private GrupoId id;
    private String nombre;
    private LocalDateTime createdAt;
}
