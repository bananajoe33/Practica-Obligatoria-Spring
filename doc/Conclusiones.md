## Sobre los desarrolladores

Este proyecto ha sido realizado por **Adrián** y **Gabriel**, estudiantes del ciclo formativo de Desarrollo de Aplicaciones Web. A lo largo del desarrollo, ambos hemos trabajado de forma conjunta, aprendiendo, investigando y resolviendo problemas técnicos reales propios de un backend profesional.

---

## Experiencia y reflexión sobre el proyecto

El proyecto ha supuesto un reto importante, especialmente porque incluye elementos avanzados como:

- Arquitectura limpia y separación por capas.  
- Uso de DTOs, comandos, casos de uso y mapeadores.  
- Persistencia con JPA y adaptación de entidades.  
- Creación y sincronización de `schema.sql` y `data.sql`.  
- Uso de una base de datos en memoria (H2) con proyección futura a MariaDB.  
- Validaciones con anotaciones y manejo de errores estructurado.  
- Pruebas continuas y corrección de inconsistencias entre dominio, infraestructura y base de datos.  
- Integración de **Thymeleaf** para la capa de presentación.  
- Implementación de **internacionalización (i18n)** con ficheros de mensajes y configuración regional.  
- Configuración y resolución de problemas relacionados con **Docker** y contenedores.

Durante todo el proceso, hemos encontrado dificultades que nos han obligado a investigar, refactorizar y mejorar la calidad del proyecto. Algunos desafíos importantes fueron:

- Ajustar todos los módulos para que siguieran un patrón claro y coherente.  
- Controlar las relaciones entre entidades y la generación de secuencias.  
- Detectar y corregir errores de mapeo y validación.  
- Mantener la estructura organizada mientras el proyecto iba creciendo.  
- Resolver problemas de **Thymeleaf**, especialmente con rutas, fragmentos y paso de datos desde el controlador.  
- Gestionar la **internacionalización**, asegurando que los mensajes se cargaran correctamente y que el cambio de idioma funcionara sin romper la navegación.  
- Afrontar errores derivados de **Docker**, como puertos ocupados, volúmenes corruptos o contenedores que no se levantaban correctamente.

Estas dificultades, lejos de ser un problema, han sido parte esencial del aprendizaje, ya que nos han permitido comprender cómo funcionan realmente las APIs robustas y las aplicaciones web completas en entornos profesionales.

---

## Conclusión

El proyecto nos ha ayudado a mejorar como desarrolladores, enseñándonos la importancia de la arquitectura, la consistencia y el trabajo colaborativo. También nos ha preparado para futuros desarrollos más complejos, incluyendo la futura migración a MariaDB, la ampliación de funcionalidades y la mejora de la capa visual con Thymeleaf.

Ha sido una experiencia valiosa y muy enriquecedora, tanto a nivel técnico como personal.
