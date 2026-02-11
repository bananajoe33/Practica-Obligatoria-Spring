package es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.web.enums;

/**
 * Contiene el listado de plantillas Thymeleaf para Alumno
 */
public enum AlumnoThymView {

    ALUMNO_LIST("alumnos-lista"),
    ALUMNO_FORM("alumnos-formulario"),
    ALUMNO_CREATED("alumnos-creado"),
    ALUMNO_DETAIL("alumnos-detalle"),
    ERROR_GENERIC("error/error-general");

    private final String path;

    AlumnoThymView(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
