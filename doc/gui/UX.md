## Experiencia de Usuario (UX)

La experiencia de usuario (UX) se ha tenido en cuenta durante el diseño de la interfaz y la navegación de la aplicación. El objetivo principal es que el usuario pueda interactuar con el sistema de forma sencilla, rápida e intuitiva.

Para ello, se han aplicado los siguientes criterios:

- **Navegación clara y directa**, con acceso rápido desde `home.html` a las principales funcionalidades.
- **Estructura coherente** en todas las vistas, utilizando plantillas Thymeleaf homogéneas.
- **Minimización de clics**, permitiendo acceder al listado de alumnos, añadir un alumno o generar un PDF en muy pocos pasos.
- **Mensajes de confirmación y feedback**, como la vista `alumno-creado.html`, que informa al usuario del resultado de sus acciones.
- **Formularios simples y validados**, como `alumnos-formulario.html`, que evita errores y mejora la interacción.
- **Listados claros y ordenados**, como `alumnos-lista.html`, que permiten localizar información rápidamente.
- **Uso de estilos CSS personalizados**, ubicados en `static/css/`, para garantizar una apariencia visual consistente y agradable.

### Vistas utilizadas en la UX

Las vistas que componen la experiencia de usuario son:

- **home.html** → Página principal y punto de entrada.  
- **alumnos-lista.html** → Listado de alumnos con acciones rápidas.  
- **alumnos-formulario.html** → Formulario para crear o editar alumnos.  
- **alumno-creado.html** → Pantalla de confirmación tras crear un alumno.  

Estas vistas, junto con los estilos CSS, conforman una experiencia de usuario fluida, coherente y fácil de usar.
