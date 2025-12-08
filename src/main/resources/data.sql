-- GRUPOS
INSERT INTO GRUPOS (id, nombre, fecha_creacion) VALUES (1, 'Grupo A', '2025-12-07T10:00:00');
INSERT INTO GRUPOS (id, nombre, fecha_creacion) VALUES (2, 'Grupo B', '2025-12-07T10:00:00');
INSERT INTO GRUPOS (id, nombre, fecha_creacion) VALUES (3, 'Grupo C', '2025-12-07T10:00:00');

-- ALUMNOS
INSERT INTO ALUMNOS (id, nombre, apellido, edad, fecha_creacion, grupo_id) VALUES (1, 'Ana', 'Gomez', 18, '2025-12-07T10:10:00', 1);
INSERT INTO ALUMNOS (id, nombre, apellido, edad, fecha_creacion, grupo_id) VALUES (2, 'Luis', 'Martinez', 19, '2025-12-07T10:12:00', 1);
INSERT INTO ALUMNOS (id, nombre, apellido, edad, fecha_creacion, grupo_id) VALUES (3, 'Maria', 'Lopez', 18, '2025-12-07T10:15:00', 2);
INSERT INTO ALUMNOS (id, nombre, apellido, edad, fecha_creacion, grupo_id) VALUES (4, 'Carlos', 'Perez', 20, '2025-12-07T10:20:00', 2);
INSERT INTO ALUMNOS (id, nombre, apellido, edad, fecha_creacion, grupo_id) VALUES (5, 'Lucia', 'Fernandez', 19, '2025-12-07T10:25:00', 3);
INSERT INTO ALUMNOS (id, nombre, apellido, edad, fecha_creacion, grupo_id) VALUES (6, 'Javier', 'Sanchez', 18, '2025-12-07T10:30:00', 3);
