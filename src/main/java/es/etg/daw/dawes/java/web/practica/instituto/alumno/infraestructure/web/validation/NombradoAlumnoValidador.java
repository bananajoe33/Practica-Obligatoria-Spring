package es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.web.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NombradoAlumnoValidador implements ConstraintValidator<NombradoAlumno, String> {

    public static final String STR_BLANCO = " ";
    public static final String STR_SALTO = "\n";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.length() == 0 || value.contains(STR_BLANCO) || value.contains(STR_SALTO))
            return false;
        return true;
    }
}
