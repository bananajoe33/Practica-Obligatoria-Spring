# Manual de Usuario – Arranque de la Aplicación Spring Boot

Este manual describe cómo iniciar la aplicación **Instituto**, desarrollada en Spring Boot, utilizando tanto la línea de comandos como **Spring Boot Dashboard** en Visual Studio Code.  
Se asume que el proyecto está configurado con **Dev Container** para el entorno de desarrollo.

---

## 1. Requisitos Previos

Antes de iniciar la aplicación, asegúrate de contar con:

- **Visual Studio Code** con la extensión **Dev Containers**  
- **Java 17** instalado dentro del Dev Container  
- **Maven** (ya incluido en el Dev Container)  
- Acceso a la carpeta del proyecto  

---

## 2. Arranque del Dev Container

El **Dev Container** proporciona un entorno aislado con todas las dependencias necesarias para ejecutar el proyecto.

1. Abre VS Code  
2. Abre la carpeta del proyecto: `File → Open Folder`  
3. Si el proyecto tiene un Dev Container, VS Code mostrará un mensaje indicando **“Reopen in Container”**  
4. Haz clic en **Reopen in Container**  
5. Espera a que el Dev Container se construya e inicie  
6. Una vez iniciado, el terminal de VS Code estará dentro del Dev Container, listo para ejecutar comandos Maven y Java  

> **Importante:** La aplicación no debe iniciarse fuera del Dev Container, ya que podrían faltar dependencias o configuraciones.

---

## 3. Arranque desde la Línea de Comandos

Dentro del Dev Container, sigue estos pasos:

1. Abre un terminal en VS Code  
2. Sitúate en la carpeta raíz del proyecto  
3. Ejecuta el siguiente comando para compilar y ejecutar la aplicación:

## 4 Una vez que la aplicación haya arrancado correctamente, accede desde tu navegador web en:

http://localhost:8080


## Ejecución de la aplicacion en terminal
```bash
mvn clean spring-boot:run.




