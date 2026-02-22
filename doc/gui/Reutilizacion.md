## Reutilización (Reusability)

La reutilización es un principio clave aplicado en el desarrollo del proyecto, permitiendo reducir duplicación de código, facilitar el mantenimiento y mejorar la escalabilidad del sistema. Este enfoque garantiza que los componentes puedan emplearse en diferentes partes de la aplicación sin necesidad de reescribir lógica o estructuras.

Los criterios de reutilización aplicados en el proyecto incluyen:

- **Plantillas Thymeleaf reutilizables**, como cabeceras, menús o estructuras comunes entre `home.html`, `alumnos-lista.html`, `alumnos-formulario.html` y `alumno-creado.html`.
- **Componentes CSS compartidos**, ubicados en `static/css/`, que permiten mantener un estilo visual uniforme sin repetir reglas en cada vista.
- **Servicios y casos de uso reutilizables**, que encapsulan la lógica de negocio para que los controladores no dupliquen código.
- **DTOs y mapeadores comunes**, utilizados tanto para creación como para edición de alumnos, evitando estructuras duplicadas.
- **Validaciones centralizadas**, aplicadas mediante anotaciones en las entidades o DTOs, reutilizables en cualquier formulario.
- **Repositorios JPA genéricos**, que permiten operaciones CRUD sin necesidad de implementar lógica repetida.
- **Mensajes de internacionalización (i18n)** reutilizados en todas las vistas, evitando textos duplicados en HTML.

### Vistas relacionadas con la reutilización

Las siguientes vistas comparten estructuras, fragmentos y estilos:

- **home.html**  
- **alumnos-lista.html**  
- **alumnos-formulario.html**  
- **alumno-creado.html**

Gracias a esta reutilización, la aplicación mantiene coherencia visual, reduce errores y facilita futuras ampliaciones sin necesidad de reescribir componentes.
