package es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.web.enums;

/**
 * Representa los posibles atributos que podemos usar
 * en los modelos de la vista para Alumno
 */
public enum ModelAttribute {
    ALUMNO_LIST("alumnos"),
    SINGLE_ALUMNO("alumno"),
    ERROR_MESSAGE("errorMsg"),
    SUCCESS_MESSAGE("successMsg");

    private final String name;

    ModelAttribute(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
