package es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.web.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import es.etg.daw.dawes.java.web.practica.instituto.alumno.application.command.alumno.CreateAlumnoCommand;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.application.command.alumno.EditAlumnoCommand;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.application.service.alumno.CreateAlumnoService;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.application.service.alumno.DeleteAlumnoService;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.application.service.alumno.EditAlumnoService;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.application.service.alumno.FindAlumnoService;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.domain.model.Alumno;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.domain.model.AlumnoId;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.mapper.AlumnoMapper;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.web.dto.AlumnoRequest;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.web.dto.AlumnoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/alumnos")
@RequiredArgsConstructor
@Tag(
    name = "Alumnos",
    description = "Operaciones relacionadas con la gestión de alumnos"
)
public class AlumnoController {

    @Value("${api.version}")
    private String apiVersion;

    private final CreateAlumnoService createAlumnoService;
    private final FindAlumnoService findAlumnoService;
    private final DeleteAlumnoService deleteAlumnoService;
    private final EditAlumnoService editAlumnoService;

    private void validarVersion() {
        if (!"1.0".equals(apiVersion)) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Versión del API incorrecta"
            );
        }
    }

    @PostMapping
    @Operation(
        summary = "Crea un alumno",
        description = "Crea un nuevo alumno en la base de datos"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Alumno creado correctamente"),
        @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    })
    public ResponseEntity<AlumnoResponse> createAlumno(
            @Valid @RequestBody AlumnoRequest alumnoRequest) {

        validarVersion();

        CreateAlumnoCommand comando = AlumnoMapper.toCommand(alumnoRequest);
        Alumno alumno = createAlumnoService.createAlumno(comando);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(AlumnoMapper.toResponse(alumno));
    }

    @GetMapping
    @Operation(
        summary = "Obtiene el listado de alumnos",
        description = "Busca en la base de datos todos los alumnos y sus detalles"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Listado de alumnos generado"),
        @ApiResponse(responseCode = "404", description = "No hay alumnos en la base de datos")
    })
    public List<AlumnoResponse> allAlumnos() {

        validarVersion();

        return findAlumnoService.findAll()
                .stream()
                .map(AlumnoMapper::toResponse)
                .toList();
    }

    @DeleteMapping("/{id}")
    @Operation(
        summary = "Elimina un alumno",
        description = "Elimina un alumno a partir de su identificador"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Alumno eliminado correctamente"),
        @ApiResponse(responseCode = "404", description = "Alumno no encontrado")
    })
    public ResponseEntity<?> deleteAlumno(@PathVariable int id) {

        validarVersion();

        deleteAlumnoService.delete(new AlumnoId(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Operation(
        summary = "Actualiza un alumno",
        description = "Actualiza los datos de un alumno existente"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Alumno actualizado correctamente"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos"),
        @ApiResponse(responseCode = "404", description = "Alumno no encontrado")
    })
    public AlumnoResponse editAlumno(
            @PathVariable int id,
            @RequestBody AlumnoRequest alumnoRequest) {

        validarVersion();

        EditAlumnoCommand comando = AlumnoMapper.toCommand(id, alumnoRequest);
        Alumno alumno = editAlumnoService.update(comando);
        return AlumnoMapper.toResponse(alumno);
    }

    // Manejo de errores de validación
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return errors;
    }
}