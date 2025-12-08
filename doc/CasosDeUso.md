# Casos de Uso del Proyecto

Este proyecto implementa diferentes casos de uso siguiendo una arquitectura limpia, separando claramente dominio, aplicación e infraestructura. A continuación, se describen los casos de uso principales para **Productos**, **Categorías**, **Grupos** y **Alumnos**.

---

## 🟦 Casos de Uso de Productos

### ➤ Crear Producto
Permite registrar un nuevo producto con nombre, precio y categoría asociada.

### ➤ Editar Producto
Actualiza los datos de un producto existente (nombre, precio o categoría).

### ➤ Obtener Producto por ID
Devuelve toda la información de un producto específico.

### ➤ Obtener Todos los Productos
Recupera una lista con todos los productos registrados.

### ➤ Eliminar Producto por ID
Borra un producto del sistema mediante su identificador.

---

## 🟩 Casos de Uso de Categorías

### ➤ Crear Categoría
Registra una nueva categoría para clasificar productos.

### ➤ Obtener Categoría por ID
Consulta los datos de una categoría concreta.

### ➤ Obtener Todas las Categorías
Lista todas las categorías disponibles.

### ➤ Eliminar Categoría
Permite borrar una categoría si no está siendo usada.

---

## 🟧 Casos de Uso de Grupos

### ➤ Crear Grupo
Crea un nuevo grupo con nombre y fecha de creación.

### ➤ Obtener Grupo por ID
Consulta los detalles de un grupo específico.

### ➤ Obtener Todos los Grupos
Recupera la lista completa de grupos registrados.

### ➤ Eliminar Grupo por ID
Elimina un grupo siempre que no tenga alumnos asociados.

---

## 🟨 Casos de Uso de Alumnos

### ➤ Crear Alumno
Añade un nuevo alumno asignado a un grupo.

### ➤ Editar Alumno
Actualiza los datos del alumno (nombre, apellido, edad o grupo).

### ➤ Obtener Alumno por ID
Devuelve los detalles de un alumno específico.

### ➤ Obtener Todos los Alumnos
Lista completa de todos los alumnos del sistema.

### ➤ Eliminar Alumno por ID
Elimina un alumno existente identificándolo por su id.

---

## ✔ Resumen General

- Todos los casos de uso siguen un patrón: **Command → UseCase → Service → Controller**.  
- Los datos se intercambian mediante **DTOs** (Requests y Responses).  
- Los repositorios del dominio no dependen de JPA, y las implementaciones están en infraestructura.  

