# Requisitos No Funcionales

Los siguientes requisitos no funcionales definen características del sistema relacionadas con rendimiento, seguridad, usabilidad y mantenibilidad.

---

## 1. Rendimiento
- **RNF1**: La consulta de alumnos o grupos no debe tardar más de 2 segundos incluso con 1000 registros.

---

## 2. Seguridad
- **RNF2**: La aplicación debe requerir login antes de permitir cualquier operación de gestión.  
- **RNF3**: Los datos de alumnos y grupos deben guardarse de forma persistente en la base de datos.

---

## 3. Usabilidad
- **RNF4**: La interfaz debe ser intuitiva y permitir realizar operaciones básicas en máximo 3 clics.  
- **RNF5**: Los formularios deben validar los campos obligatorios antes de enviar los datos.  
- **RNF8**: La aplicación debe incluir vistas desarrolladas con **Thymeleaf**, utilizando plantillas consistentes y estructuradas.  
- **RNF9**: Los estilos visuales deben estar centralizados en archivos **CSS**, garantizando una apariencia uniforme en todas las páginas.

---

## 4. Mantenibilidad
- **RNF6**: El sistema debe estar desarrollado en capas (controlador, servicio, repositorio) para facilitar futuras ampliaciones.

---

## 5. Compatibilidad
- **RNF7**: La aplicación será web y compatible con los navegadores modernos (Chrome, Edge, Firefox).
