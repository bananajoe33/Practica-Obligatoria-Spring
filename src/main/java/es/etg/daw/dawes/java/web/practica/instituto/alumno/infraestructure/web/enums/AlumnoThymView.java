package es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.web.enums;


public enum AlumnoThymView {

    // 🏠 Vista principal
    HOME("home"),

    // 📚 Alumno
    ALUMNO_LIST("alumnos-lista"),
    ALUMNO_FORM("alumnos-formulario"),
    ALUMNO_CREATED("alumnos-creado"),
    ALUMNO_DETAIL("alumnos-detalle"),
    
    // 📄 PDF de alumnos
    ALUMNO_LIST_PDF("pdf/alumnos-lista-pdf"),

    // ❌ Error
    ERROR_GENERIC("error/error-general");

    private final String path;

    AlumnoThymView(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}

