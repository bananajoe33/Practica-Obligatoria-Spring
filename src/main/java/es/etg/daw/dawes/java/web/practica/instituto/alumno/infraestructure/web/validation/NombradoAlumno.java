package es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.web.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NombradoAlumnoValidador.class)
@Documented
public @interface NombradoAlumno {

    String message() default "{es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.web.validation.NombradoAlumno}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
