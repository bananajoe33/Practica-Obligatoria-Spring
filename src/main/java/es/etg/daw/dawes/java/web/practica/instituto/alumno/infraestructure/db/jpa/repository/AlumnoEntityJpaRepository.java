package es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.db.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.db.jpa.entity.AlumnoEntity;

@Repository
public interface AlumnoEntityJpaRepository extends JpaRepository<AlumnoEntity, Integer> {

    AlumnoEntity findByNombre(String nombre);
}
