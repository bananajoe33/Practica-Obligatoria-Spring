

/**package es.etg.daw.dawes.java.web.practica.instituto;



import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import es.etg.daw.dawes.java.web.practica.instituto.alumno.domain.model.Alumno;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.web.dto.AlumnoRequest;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.web.dto.AlumnoResponse;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class AlumnoControllerTest {

    public static String ENDPOINT = "/alumnos";

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private JacksonTester<AlumnoRequest> jsonAlumnoRequest;

    @Autowired
    private JacksonTester<AlumnoResponse> jsonAlumnoResponse;

    private Alumno alumnoTest;

    @BeforeEach
    public void setUp() {
        mapper.registerModule(new JavaTimeModule());
        // Creamos un alumno de prueba
        alumnoTest = new Alumno();
        alumnoTest.setNombre("Adrian");
        alumnoTest.setApellido("Perez");
        alumnoTest.setEdad(20);
        alumnoTest.setFechaCreacion(LocalDateTime.now());
    }

    @Test
    @Order(1)
    public void getAll() throws Exception {
        // Primero creamos un alumno
        mockMvc.perform(
                post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonAlumnoRequest.write(new AlumnoRequest(alumnoTest)).getJson())
                        .accept(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        MockHttpServletResponse response = mockMvc.perform(
                get(ENDPOINT).accept(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        List<AlumnoResponse> res = mapper.readValue(response.getContentAsString(),
                mapper.getTypeFactory().constructCollectionType(List.class, AlumnoResponse.class));

        assertAll(
                () -> assertEquals(HttpStatus.OK.value(), response.getStatus()),
                () -> assertTrue(res.size() > 0)
        );
    }

    @Test
    @Order(10)
    public void save() throws Exception {
        AlumnoRequest req = new AlumnoRequest(alumnoTest);

        MockHttpServletResponse response = mockMvc.perform(
                post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonAlumnoRequest.write(req).getJson())
                        .accept(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        AlumnoResponse res = mapper.readValue(response.getContentAsString(), AlumnoResponse.class);

        assertAll(
                () -> assertEquals(HttpStatus.CREATED.value(), response.getStatus()),
                () -> assertEquals(res.nombre(), alumnoTest.getNombre()),
                () -> assertEquals(res.apellido(), alumnoTest.getApellido()),
                () -> assertEquals(res.edad(), alumnoTest.getEdad()),
                () -> assertTrue(res.id() > 0)
        );
    }

    @Test
    @Order(20)
    public void update() throws Exception {
        // Crear alumno primero
        MockHttpServletResponse createResponse = mockMvc.perform(
                post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonAlumnoRequest.write(new AlumnoRequest(alumnoTest)).getJson())
                        .accept(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        AlumnoResponse created = mapper.readValue(createResponse.getContentAsString(), AlumnoResponse.class);

        // Actualizamos datos
        alumnoTest.setEdad(21);
        AlumnoRequest req = new AlumnoRequest(alumnoTest);

        MockHttpServletResponse response = mockMvc.perform(
                put(ENDPOINT + "/" + created.id())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonAlumnoRequest.write(req).getJson())
                        .accept(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        AlumnoResponse res = mapper.readValue(response.getContentAsString(), AlumnoResponse.class);

        assertAll(
                () -> assertEquals(HttpStatus.OK.value(), response.getStatus()),
                () -> assertEquals(res.edad(), 21)
        );
    }

    @Test
    @Order(30)
    public void delete() throws Exception {
        // Crear alumno primero
        MockHttpServletResponse createResponse = mockMvc.perform(
                post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonAlumnoRequest.write(new AlumnoRequest(alumnoTest)).getJson())
                        .accept(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        AlumnoResponse created = mapper.readValue(createResponse.getContentAsString(), AlumnoResponse.class);

        MockHttpServletResponse response = mockMvc.perform(
                delete(ENDPOINT + "/" + created.id())
                        .accept(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        assertAll(
                () -> assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatus())
        );
    }
}
**/