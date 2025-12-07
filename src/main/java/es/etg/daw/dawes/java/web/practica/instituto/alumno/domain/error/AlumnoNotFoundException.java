package es.etg.daw.dawes.java.web.practica.instituto.alumno.domain.error;

import es.etg.daw.dawes.java.web.practica.instituto.common.domain.error.EntityNotFoundException;

public class AlumnoNotFoundException extends EntityNotFoundException {

    public static final String ENTIDAD = "alumno";

    public AlumnoNotFoundException() {
        super(ENTIDAD);
    }

    public AlumnoNotFoundException(int id) {
        super(ENTIDAD, id);
    }
}
