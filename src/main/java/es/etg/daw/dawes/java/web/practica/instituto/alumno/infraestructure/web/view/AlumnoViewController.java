package es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.web.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.etg.daw.dawes.java.web.practica.instituto.alumno.application.command.alumno.CreateAlumnoCommand;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.application.service.alumno.CreateAlumnoService;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.application.service.alumno.FindAlumnoService;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.domain.model.Alumno;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.domain.model.GrupoId;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.web.constants.WebRoutes;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.web.enums.AlumnoThymView;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.web.enums.ModelAttribute; // ✅ enums
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AlumnoViewController {

    private final FindAlumnoService findAlumnoService;
    private final CreateAlumnoService createAlumnoService;

    // Listado de alumnos
    @GetMapping(WebRoutes.ALUMNOS_BASE)
    public String listar(Model model) {
        model.addAttribute(ModelAttribute.ALUMNO_LIST.getName(), findAlumnoService.findAll());
        return AlumnoThymView.ALUMNO_LIST.getPath();
    }

    // Formulario para nuevo alumno
    @GetMapping(WebRoutes.ALUMNOS_NUEVO)
    public String formulario(Model model) {
        model.addAttribute(ModelAttribute.SINGLE_ALUMNO.getName(), new Alumno(null, null, null, 0, null, null));
        return AlumnoThymView.ALUMNO_FORM.getPath();
    }

    // Crear alumno
    @PostMapping(WebRoutes.ALUMNOS_NUEVO)
    public String crearAlumno(
            @RequestParam String nombre,
            @RequestParam String apellido,
            @RequestParam int edad,
            @RequestParam(required = false) Integer grupoId,
            Model model) {

        GrupoId grupo = (grupoId != null) ? new GrupoId(grupoId) : null;

        CreateAlumnoCommand command = new CreateAlumnoCommand(
                nombre,
                apellido,
                edad,
                grupo
        );

        createAlumnoService.createAlumno(command);

        return "redirect:" + WebRoutes.ALUMNOS_BASE;
    }
}
