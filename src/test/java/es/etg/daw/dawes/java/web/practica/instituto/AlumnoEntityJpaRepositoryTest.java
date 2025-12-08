package es.etg.daw.dawes.java.web.practica.instituto;


import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.db.jpa.entity.AlumnoEntity;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.db.jpa.repository.AlumnoEntityJpaRepository;



@DataJpaTest(showSql = true)
public class AlumnoEntityJpaRepositoryTest {

    @Autowired
    private AlumnoEntityJpaRepository repository;

    // Método auxiliar para crear un alumno de prueba
    private AlumnoEntity createAlumnoTest() {
        AlumnoEntity alumno = new AlumnoEntity();
        alumno.setNombre("Adrian");
        alumno.setApellido("Perez");
        alumno.setEdad(20);
        alumno.setFechaCreacion(LocalDateTime.now());
        return alumno;
    }

    @Test
    @Order(1)
    void findAll() {
        AlumnoEntity alumno = repository.save(createAlumnoTest());
        var alumnos = repository.findAll();

        assertAll(
            () -> assertNotNull(alumnos),
            () -> assertTrue(!alumnos.isEmpty())
        );
    }

    @Test
    @Order(2)
    void findById() {
        AlumnoEntity alumno = repository.save(createAlumnoTest());
        var found = repository.findById(alumno.getId()).get();

        assertAll(
            () -> assertNotNull(found),
            () -> assertEquals(found.getId(), alumno.getId()),
            () -> assertEquals(found.getNombre(), alumno.getNombre()),
            () -> assertEquals(found.getApellido(), alumno.getApellido())
        );
    }

    @Test
    @Order(3)
    void create() {
        AlumnoEntity alumno = createAlumnoTest();
        var saved = repository.save(alumno);

        assertAll(
            () -> assertNotNull(saved),
            () -> assertTrue(saved.getId() != null)
        );
    }

    @Test
    @Order(4)
    void update() {
        AlumnoEntity alumno = repository.save(createAlumnoTest());
        alumno.setNombre("Gabriel");
        var updated = repository.save(alumno);

        assertEquals("Gabriel", updated.getNombre());
    }

    @Test
    @Order(5)
    void delete() {
        AlumnoEntity alumno = repository.save(createAlumnoTest());
        repository.delete(alumno);
        var exists = repository.findById(alumno.getId()).isEmpty();

        assertTrue(exists);
    }
}
