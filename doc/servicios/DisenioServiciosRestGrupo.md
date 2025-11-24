# Diseños de los servicios REST - Grupo
| Endpoint        | Petición HTTP | Body | Response code | Response body | Posibles errores |
|-----------------|---------------|------|---------------|---------------|-----------------|
| /grupos         | GET           | N/A  | 200 (OK)      | `{ "grupos": [{ "id": 1, "nombre": "Grupo 1", "codigo": "G001" }] }` | — |
| /grupos         | POST          | `{ "nombre": "Grupo nuevo", "codigo": "G002" }` | 201 (CREATED) | `{ "nombre": "Grupo nuevo", "codigo": "G002" }` | 400 (Solicitud incorrecta) |
| /grupos/{id}    | PUT           | `{ "nombre": "Grupo actualizado", "codigo": "G003" }` | 200 (OK) | `{ "id": 1, "nombre": "Grupo actualizado", "codigo": "G003" }` | 400 (Solicitud incorrecta), 404 (No encontrado) |
| /grupos/{id}    | DELETE        | N/A  | 204 (No Content) | N/A | 404 (No encontrado) |
