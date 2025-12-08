## Base de datos utilizada

Actualmente el proyecto utiliza **H2 Database** como base de datos principal durante el desarrollo.

H2 es una base de datos en memoria, ligera y rápida, que no requiere instalación y permite cargar automáticamente los archivos `schema.sql` y `data.sql` cada vez que se inicia la aplicación. Esto facilita el trabajo en entornos de desarrollo y pruebas, ya que siempre se parte de un estado inicial limpio.

Además, proporciona una consola web integrada para visualizar y consultar las tablas fácilmente mientras se desarrolla.

En el futuro, está previsto migrar la aplicación a **MariaDB**, una base de datos más robusta y persistente, adecuada para entornos de producción. MariaDB permitirá trabajar con volúmenes de datos más grandes y ofrecerá mayor estabilidad y rendimiento.

**Resumen:**
- **H2 (actual):** Usada en desarrollo. Rápida, en memoria, sin instalación, se reinicia en cada arranque.
- **MariaDB (futuro):** Se usará en producción. Persistente, estable y optimizada para grandes cantidades de datos.
