## Diseño de Interacción (IxD)

El Diseño de Interacción (IxD) se centra en cómo el usuario **interactúa** con la aplicación, asegurando que cada acción tenga una respuesta clara, predecible y coherente. En este proyecto, el IxD se ha aplicado para que la navegación y las operaciones relacionadas con alumnos sean fluidas y fáciles de entender.

Los principios de IxD aplicados en la aplicación son:

- **Consistencia en la navegación**, utilizando rutas claras y botones ubicados siempre en posiciones similares.
- **Retroalimentación inmediata**, como mensajes de confirmación en `alumno-creado.html` o validaciones en `alumnos-formulario.html`.
- **Minimización de pasos**, permitiendo acceder desde `home.html` al listado y desde ahí a las acciones principales.
- **Acciones visibles y accesibles**, como los botones de “Añadir alumno”, “Editar”, “Eliminar” o “Generar PDF” en `alumnos-lista.html`.
- **Prevención de errores**, mediante validaciones en formularios y confirmaciones visuales.
- **Flujo de interacción claro**, donde cada vista lleva de forma natural a la siguiente sin confundir al usuario.

### Vistas relacionadas con el IxD

El diseño de interacción se apoya en las siguientes vistas:

- **home.html** → Punto de entrada y distribución hacia las funcionalidades principales.  
- **alumnos-lista.html** → Centro de interacción con los alumnos: ver, editar, eliminar, generar PDF.  
- **alumnos-formulario.html** → Interacción directa para crear o modificar datos.  
- **alumno-creado.html** → Feedback inmediato tras completar una acción.  

### Estilos CSS en el IxD

Los estilos ubicados en:


refuerzan el diseño de interacción mediante:

- Botones destacados para acciones importantes  
- Colores consistentes para estados (éxito, error, acción)  
- Tablas legibles y ordenadas  
- Formularios claros y fáciles de completar  

El IxD garantiza que el usuario no solo vea una interfaz bonita (UI) ni solo tenga una experiencia agradable (UX), sino que **entienda cómo interactuar con la aplicación de forma natural y sin esfuerzo**.
