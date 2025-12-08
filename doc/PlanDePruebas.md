# Plan de Pruebas – Módulos Grupo y Alumno

Este documento define el plan de pruebas para los módulos de Grupo y Alumno del sistema.  
El objetivo es asegurar que las funcionalidades principales funcionan correctamente y que los datos se gestionan de forma consistente.  
Las pruebas del módulo Grupo se documentan, pero su implementación se realizará en una fase futura.

---

# 1. Pruebas del Módulo Grupo (Pendientes de Implementación)

El módulo Grupo gestiona las entidades que representan agrupaciones de alumnos. Aunque su integración final será posterior, las pruebas previstas son las siguientes.

## 1.1. Crear Grupo
**Objetivo:** comprobar que se puede registrar correctamente un grupo.  
**Datos requeridos:** nombre.  
**Resultado esperado:**  
- El grupo se crea correctamente con un ID generado.  
- El sistema devuelve un código HTTP 201 (Created).

## 1.2. Obtener Grupo por ID
**Objetivo:** validar que el sistema devuelve la información de un grupo existente.  
**Resultado esperado:**  
- El grupo correspondiente se devuelve correctamente.  
- Código HTTP 200 (OK).

## 1.3. Listar Todos los Grupos
**Objetivo:** comprobar que el sistema devuelve todos los grupos registrados.  
**Resultado esperado:**  
- Lista completa de grupos.  
- Código HTTP 200 (OK).

## 1.4. Eliminar Grupo
**Objetivo:** verificar que un grupo puede eliminarse cuando no tiene alumnos asociados.  
**Resultados esperados:**  
- Si no tiene alumnos: HTTP 204 (No Content).  
- Si tiene alumnos asignados: HTTP 409 (Conflict).

---

# 2. Pruebas del Módulo Alumno

El módulo Alumno está completamente implementado, por lo que las pruebas se enfocan en validar las operaciones CRUD y la consistencia de datos.

## 2.1. Crear Alumno
**Objetivo:** confirmar que el sistema registra alumnos de forma correcta.

### Escenarios:
- Datos válidos: el alumno se crea correctamente y se devuelve HTTP 201.
- Grupo inexistente: se debe devolver un error HTTP 400 o 404.
- Edad fuera de rango permitido: se debe devolver HTTP 400.
- Nombre o apellido vacíos: se debe devolver HTTP 400.

## 2.2. Editar Alumno
**Objetivo:** verificar que se puede actualizar la información de un alumno.

### Escenarios:
- ID existente con datos válidos: actualización correcta, HTTP 200.
- Alumno inexistente: respuesta HTTP 404.
- Grupo inexistente: error HTTP 400 o 404.

## 2.3. Obtener Alumno por ID
**Objetivo:** comprobar la recuperación de un alumno concreto.

### Escenarios:
- Alumno existente: datos correctos, HTTP 200.
- Alumno inexistente: HTTP 404.

## 2.4. Listar Todos los Alumnos
**Objetivo:** validar la obtención de la lista completa de alumnos.  
**Resultado esperado:**  
- Se devuelve la colección completa de alumnos.  
- HTTP 200.

## 2.5. Eliminar Alumno
**Objetivo:** asegurar que el sistema permite eliminar alumnos correctamente.

### Escenarios:
- Alumno existente: eliminación correcta, HTTP 204.
- Alumno inexistente: HTTP 404.

---

# Resumen

- El módulo Alumno cuenta con un plan de pruebas completo, listo para ejecución.  
- El módulo Grupo tiene un conjunto de pruebas definido, pero su desarrollo e implementación se realizarán más adelante.  
- Este plan garantiza la verificación del comportamiento esperado en ambos módulos y facilita la transición hacia entornos más complejos en fases futuras.

