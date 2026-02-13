package es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.web.view;

import java.io.OutputStream;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.xhtmlrenderer.pdf.ITextRenderer;

import es.etg.daw.dawes.java.web.practica.instituto.alumno.application.command.alumno.CreateAlumnoCommand;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.application.service.alumno.CreateAlumnoService;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.application.service.alumno.FindAlumnoService;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.domain.model.Alumno;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.domain.model.GrupoId;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.web.constants.ModelAttribute;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.web.constants.WebRoutes;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.web.enums.AlumnoThymView;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AlumnoViewController {

    private final FindAlumnoService findAlumnoService;
    private final CreateAlumnoService createAlumnoService;
    private final SpringTemplateEngine templateEngine; // Thymeleaf

    // 🏠 Home
    @GetMapping(WebRoutes.HOME)
    public String home(Model model) {
        model.addAttribute(ModelAttribute.PAGE_TITLE.getName(), "Menú Principal - Instituto");
        return AlumnoThymView.HOME.getPath();
    }

    // 📌 Listado de alumnos
    @GetMapping(WebRoutes.ALUMNOS_BASE)
    public String listar(Model model) {
        model.addAttribute(ModelAttribute.ALUMNO_LIST.getName(), findAlumnoService.findAll());
        return AlumnoThymView.ALUMNO_LIST.getPath();
    }

    // 📌 Formulario para nuevo alumno
    @GetMapping(WebRoutes.ALUMNOS_NUEVO)
    public String formulario(Model model) {
        model.addAttribute(ModelAttribute.SINGLE_ALUMNO.getName(), new Alumno(null, null, null, 0, null, null));
        return AlumnoThymView.ALUMNO_FORM.getPath();
    }

    // 📌 Crear alumno
    @PostMapping(WebRoutes.ALUMNOS_NUEVO)
    public String crearAlumno(
            @RequestParam String nombre,
            @RequestParam String apellido,
            @RequestParam int edad,
            @RequestParam(defaultValue = "1") Integer grupoId) {

        CreateAlumnoCommand command = new CreateAlumnoCommand(
                nombre,
                apellido,
                edad,
                new GrupoId(grupoId)
        );

        createAlumnoService.createAlumno(command);
        return "redirect:" + WebRoutes.ALUMNOS_BASE;
    }

    @GetMapping(WebRoutes.ALUMNOS_PDF)
    public void exportarPDF(HttpServletResponse response) throws Exception {

        List<Alumno> alumnos = findAlumnoService.findAll();

        Context context = new Context();
        context.setVariable("alumnos", alumnos);

        String htmlContent = templateEngine.process(AlumnoThymView.ALUMNO_LIST_PDF.getPath(), context);

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=alumnos.pdf");

        try (OutputStream outputStream = response.getOutputStream()) {
            ITextRenderer renderer = new ITextRenderer();

            // Agregar base URL para resolver recursos estáticos (CSS, imágenes, etc.)
            String baseUrl = "file:///" + System.getProperty("user.dir") + "/src/main/resources/templates/";
            renderer.setDocumentFromString(htmlContent, baseUrl);

            renderer.layout();
            renderer.createPDF(outputStream);
        }
    }
}
