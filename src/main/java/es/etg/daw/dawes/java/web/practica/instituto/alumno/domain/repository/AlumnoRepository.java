package es.etg.daw.dawes.java.web.practica.instituto.alumno.domain.repository;

import java.util.Optional;

import es.etg.daw.dawes.java.web.practica.instituto.alumno.domain.model.Alumno;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.domain.model.AlumnoId;
import es.etg.daw.dawes.java.web.practica.instituto.common.domain.repository.CRUDRepository;

public interface AlumnoRepository extends CRUDRepository<Alumno, AlumnoId> {

    Optional<Alumno> getByName(String name);
}
