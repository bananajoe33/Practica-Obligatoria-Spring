package es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.db.jpa.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Builder
@Table(name = "GRUPOS")
public class GrupoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    
    public GrupoEntity() {}

    
}
