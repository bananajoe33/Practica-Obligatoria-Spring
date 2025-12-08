CREATE TABLE GRUPOS (
    id INT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    fecha_creacion TIMESTAMP NOT NULL
);

CREATE TABLE ALUMNOS (
    id INT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL,
    edad INT NOT NULL,
    fecha_creacion TIMESTAMP NOT NULL,
    grupo_id INT NOT NULL,
    CONSTRAINT fk_grupo FOREIGN KEY (grupo_id) REFERENCES GRUPOS(id)
);
