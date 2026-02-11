package es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.web.constants;

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
        return name;
    }
}
