Este proyecto consiste en la automatización del login de Facebook con credenciales inválidas: https://www.facebook.com/.
Se usa el framework de Serenity, se utilizó el patrón Page Object Model, además de librerías Selenium, Cucumber, lenguaje de programación Java y el gestor de dependencias Maven.
Para Java se ejecutó el proyecto con la versión: 11.0.16.1 y Maven con la versión: 3.8.6.
Para correr el proyecto de forma exitosa se debe descargar el Java y Maven en la máquina local y configurar las variables de entorno del sistema.
Para ejecutar las pruebas en el ambiente local, se debe ingresar al sitio: https://www.selenium.dev/downloads/ y descargar la última versión estable
del archivo jar selenium-server. Abrir un cmd en la ruta del archivo descargado y copiar el comando: "java -jar selenium-server-x.x.x.jar standalone" de acuerdo a la versión descargada.
Para verificar que el servidor está arriba probar la dirección: http://localhost:4444/ y se debe abrir la página del selenium-server.
Seguidamente se debe descargar el proyecto del repositorio y ejecutar en la terminal del IDE (recomendado IntelliJ IDEA) el comando: mvn clean verify.
Apenas termine la ejecución se puede observar el reporte en la carpeta generada: target/site/serenity/index.html (abrir con navegador de preferencia).

La estructura del proyecto está conformada así:
package pages => se sitúan las clases pages en las cuales se tienen los locators y métodos (interación con los elementos web). Estas clases heredan de BasePage
la cual es una clase que hereda de PageObject y contiene métodos muy genéricos que pueden ser llamados desde las clases pages.

Package stepdefinitions => Se tienen las clases que comunican los features con los steps y hacen el llamado de los métodos de las clases pages.

Class SerenityRunnerTest => Se tiene el runner que se corre y hace el llamdo al feature corrrespondiente.

Source features => Se ubican los archivos .feature que contienen los escenarios BDD con notación Gherkin.

File serenity.conf => En este archivo se inicializa la url del esceanrio automatizado, se configuran capabilities de los navegadores y configuraciones de Serenity.

File pom.xml => Archivo maven donde se gestionan las dependencias de las diferentes librerías que se utilizarán en el proyecto.