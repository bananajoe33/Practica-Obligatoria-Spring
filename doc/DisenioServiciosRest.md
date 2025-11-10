# Diseños de los servicios REST
| Endpoint        | Petición HTTP | Body | Response code | Response body | Posibles errores |
|-----------------|----------------|------|----------------|----------------|------------------|
| /alumnos        | GET            | N/A  | 200 (OK)       | `{ "alumnos": { "id": 1, "nombre": "Alumno 1", "apellido": "Apellido 1" } }` | — |
| /alumnos        | POST           | `{ "nombre": "Alumno nuevo", "apellido": "Apellido nuevo" }` | 201 (CREATED) | `{ "nombre": "Alumno nuevo", "apellido": "Alumno nuevo" }` | 400 (Solicitud incorrecta) |
| /alumnos/{id}   | PUT            | `{ "nombre": "Alumno actualizado", "apellido": "Apellido actualizado" }` | 200 (OK) | `{ "id": 1, "nombre": "Alumno actualizado", "apellido": "Alumno actualizado" }` | 400 (Solicitud incorrecta), 404 (No encontrado) |
| /alumnos/{id}   | DELETE         | N/A  | 204 (No Content) | N/A | 404 (No encontrado) |
