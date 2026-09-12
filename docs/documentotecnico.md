&#x20;Documento Técnico

&#x20;GA8-220501096-AA1-EV02

&#x20;Módulos integrados



\*\*Proyecto:\*\* AprendizWeb

\*\*Tecnología principal:\*\* Java Web

\*\*Servidor:\*\* Apache Tomcat

\*\*Base de datos:\*\* MySQL

\*\*Control de versiones:\*\* Git y GitHub

\*\*Pruebas:\*\* JUnit 5



\---



1\. Introducción



El presente documento describe el desarrollo e integración del proyecto \*\*AprendizWeb\*\*, una aplicación web desarrollada en Java que permite registrar información de aprendices mediante un formulario web y almacenarla en una base de datos MySQL.



El proyecto integra diferentes componentes de software, organizados de manera que cada uno cumpla una función específica. La aplicación utiliza un Servlet como controlador, una clase modelo para representar los datos del aprendiz, clases DAO para realizar las operaciones con la base de datos y una página JSP como interfaz para el usuario.



También se incluyen pruebas automatizadas para verificar el funcionamiento de los componentes principales del proyecto y se utiliza Git y GitHub para el control y seguimiento de las versiones del código.



\---



2\. Objetivo



Desarrollar e integrar los módulos componentes de una aplicación web para el registro de aprendices, aplicando buenas prácticas de programación, separación de responsabilidades, conexión con una base de datos, pruebas de software y control de versiones.



\---

- Requisitos del módulo
Requisitos funcionales
Código	Requisito
RF01	El sistema debe permitir registrar un aprendiz mediante un formulario web.
RF02	El formulario debe permitir ingresar nombre, apellido, correo electrónico y teléfono.
RF03	El sistema debe recibir los datos mediante una solicitud HTTP POST.
RF04	El Servlet debe procesar los datos recibidos y crear un objeto Aprendiz.
RF05	El sistema debe almacenar los datos del aprendiz en la tabla aprendiz de MySQL.
RF06	El sistema debe informar al usuario si el registro fue guardado correctamente o si ocurrió un error.
RF07	El proyecto debe contar con pruebas automatizadas para verificar componentes principales.
Requisitos no funcionales
Código	Requisito
RNF01	El proyecto debe utilizar Java 17 como versión de compilación.
RNF02	La aplicación debe poder desplegarse como archivo WAR en Apache Tomcat.
RNF03	La aplicación debe utilizar MySQL como sistema gestor de base de datos.
RNF04	La conexión entre Java y MySQL debe realizarse mediante JDBC.
RNF05	Las dependencias y el proceso de compilación deben gestionarse mediante Maven.
RNF06	Las pruebas automatizadas deben utilizar JUnit 5.
RNF07	El código fuente debe mantenerse mediante Git y un repositorio remoto en GitHub.
RNF08	El proyecto debe mantener separación de responsabilidades entre modelo, vista, controlador y acceso a datos.


\---


3\. Descripción general del sistema



\*\*AprendizWeb\*\* es una aplicación web que permite ingresar los siguientes datos de un aprendiz:



\- Nombre.

\- Apellido.

\- Correo electrónico.

\- Teléfono.



La información es enviada desde un formulario web al Servlet correspondiente. El Servlet recibe los datos, crea un objeto de tipo `Aprendiz` y utiliza la clase `AprendizDAO` para almacenarlos en la base de datos MySQL.



La aplicación se ejecuta sobre el servidor Apache Tomcat y utiliza tecnologías Java Web basadas en Jakarta Servlet.



\---



4\. Tecnologías utilizadas



| Tecnología | Utilidad |

|---|---|

| Java 17 | Lenguaje de programación |

| Jakarta Servlet | Procesamiento de solicitudes web |

| JSP | Interfaz web |

| Apache Tomcat 10.1.57 | Servidor de aplicaciones |

| MySQL | Sistema gestor de base de datos |

| JDBC | Conexión entre Java y MySQL |

| Maven | Gestión del proyecto y dependencias |

| JUnit 5 | Pruebas automatizadas |

| Git | Control de versiones |

| GitHub | Repositorio remoto |



\---



5\. Estructura del proyecto



La aplicación se encuentra organizada en diferentes paquetes de acuerdo con la responsabilidad de cada componente:



AprendizWeb

├── src

│   ├── main

│   │   ├── java

│   │   │   └── com

│   │   │       └── sena

│   │   │           └── aprendiz

│   │   │               ├── controller

│   │   │               │   └── AprendizServlet.java

│   │   │               ├── dao

│   │   │               │   ├── AprendizDAO.java

│   │   │               │   └── Conexion.java

│   │   │               └── model

│   │   │                   └── Aprendiz.java

│   │   └── webapp

│   │       ├── index.jsp

│   │       └── WEB-INF

│   │           └── web.xml

│   │

│   └── test

│       └── java

│           └── com

│               └── sena

│                   └── aprendiz

│                       ├── dao

│                       │   └── AprendizDAOTest.java

│                       └── model

│                           └── AprendizTest.java

│

├── docs

├── pom.xml

└── .gitignore



\---



6\. Arquitectura del sistema



El proyecto utiliza una estructura basada en el patrón MVC (Modelo-Vista-Controlador), complementada con una capa de acceso a datos mediante el patrón DAO.



La distribución de responsabilidades es la siguiente:



6.1 Modelo



El paquete `model` contiene la clase `Aprendiz.java`, que representa la información de un aprendiz.



La clase contiene los atributos:



\- `nombre`

\- `apellido`

\- `correo`

\- `telefono`



También contiene constructores, métodos `get` y `set` para administrar los datos del objeto.



6.2 Vista



La interfaz de usuario se encuentra en:



`index.jsp`



Esta página presenta el formulario utilizado para ingresar los datos del aprendiz.



Los datos son enviados mediante una solicitud HTTP POST hacia el Servlet encargado del registro.



6.3 Controlador



El paquete `controller` contiene:



`AprendizServlet.java`



Este componente recibe las solicitudes provenientes del formulario, obtiene los datos enviados por el usuario, crea el objeto `Aprendiz` y solicita al DAO que almacene la información.



También permite responder a solicitudes GET para comprobar que el Servlet se encuentra disponible.



6.4 Acceso a datos



El paquete `dao` contiene:



\- `AprendizDAO.java`

\- `Conexion.java`



`AprendizDAO.java` contiene la operación para guardar un aprendiz utilizando una sentencia SQL preparada.



`Conexion.java` se encarga de establecer la conexión entre la aplicación Java y la base de datos MySQL mediante JDBC.



6.5 Base de datos



La aplicación utiliza una base de datos MySQL denominada `aprendizweb`.



La información de los aprendices se almacena en la tabla `aprendiz`.



Entradas y salidas del módulo
Entradas

Los datos ingresados por el usuario desde index.jsp son:

Campo	     Tipo	    Descripción
nombre	    Texto	 Nombre del aprendiz
apellido	Texto	 Apellido del aprendiz
correo	    Texto	 Correo electrónico
telefono	Texto	 Número telefónico

Estos datos son enviados mediante una solicitud HTTP POST al endpoint:

/registrar
Procesamiento

AprendizServlet recibe los parámetros enviados, crea un objeto Aprendiz y lo entrega a AprendizDAO.

El DAO utiliza JDBC y PreparedStatement para ejecutar la operación de inserción en MySQL.

Salidas

El módulo produce dos resultados principales:

Registro exitoso:

Registro guardado correctamente

Error durante el registro:

Error al guardar el registro

Además, cuando el registro es exitoso, los datos quedan almacenados en:

Base de datos: aprendizweb
Tabla: aprendiz


##  Componentes del módulo

El módulo de registro de aprendices está compuesto por los siguientes componentes:

###  Interfaz web — `index.jsp`

Presenta el formulario mediante el cual el usuario ingresa los datos del aprendiz.

**Entrada:** nombre, apellido, correo y teléfono.

**Salida:** envío de los datos mediante una solicitud HTTP POST al Servlet.

###  Controlador — `AprendizServlet.java`

Recibe y procesa la información enviada desde el formulario.

Sus principales funciones son:

- Recibir los parámetros enviados.
- Crear un objeto `Aprendiz`.
- Asignar los datos recibidos al objeto.
- Solicitar al DAO el almacenamiento del registro.
- Informar al usuario el resultado de la operación.

###  Modelo — `Aprendiz.java`

Representa los datos de un aprendiz dentro de la aplicación.

Contiene los atributos:

- `nombre`
- `apellido`
- `correo`
- `telefono`

También proporciona métodos `get` y `set` para administrar estos datos.

###  Acceso a datos — `AprendizDAO.java`

Se encarga de realizar la operación de almacenamiento en la base de datos.

Utiliza JDBC y `PreparedStatement` para ejecutar la sentencia SQL de inserción.

###  Conexión — `Conexion.java`

Establece la conexión entre la aplicación Java y la base de datos MySQL mediante JDBC.

###  Base de datos — MySQL

Almacena permanentemente la información registrada.

La aplicación utiliza la base de datos `aprendizweb` y la tabla `aprendiz`.

###  Pruebas — JUnit 5

Permite verificar el funcionamiento de los componentes principales mediante pruebas automatizadas.

Se cuenta con pruebas para el modelo `Aprendiz` y para el acceso a datos mediante `AprendizDAOTest`.


\---



7\. Flujo de funcionamiento



El proceso principal de registro funciona de la siguiente manera:



1\. El usuario ingresa los datos en el formulario de `index.jsp`.

2\. El formulario envía los datos mediante una solicitud POST.

3\. `AprendizServlet` recibe la solicitud.

4\. El Servlet obtiene los parámetros enviados.

5\. Se crea un objeto `Aprendiz`.

6\. `AprendizDAO` recibe el objeto.

7\. `Conexion` establece la conexión con MySQL.

8\. El DAO ejecuta la sentencia SQL `INSERT`.

9\. Si la operación es correcta, el usuario recibe un mensaje de registro exitoso.

10\. La información queda almacenada en la base de datos.



\---



8\. Separación de responsabilidades



La separación de los componentes permite mantener el código organizado y facilita su mantenimiento.



Cada paquete tiene una responsabilidad específica:



| Paquete | Responsabilidad |

|---|---|

| `model` | Representar los datos del aprendiz |

| `controller` | Gestionar las solicitudes HTTP |

| `dao` | Realizar operaciones con la base de datos |

| `webapp` | Presentar la interfaz al usuario |

| `test` | Ejecutar pruebas automatizadas |





\---



9\. Configuración del entorno de desarrollo



Para el desarrollo y ejecución de AprendizWeb se utilizaron las siguientes herramientas:



9.1 Java



El proyecto utiliza \*\*Java 17\*\* como versión de compilación.



La configuración del proyecto en Maven utiliza la propiedad `maven.compiler.release` con el valor `17`, permitiendo compilar el código utilizando las características y compatibilidad correspondientes a esta versión.



9.2 Maven



Maven se utiliza para administrar la estructura del proyecto, las dependencias y el proceso de compilación.



El proyecto está configurado con empaquetado:



`WAR`



El archivo `pom.xml` contiene las dependencias necesarias para Jakarta Servlet, MySQL y JUnit.



9.3 Apache Tomcat



La aplicación se despliega como un archivo WAR en \*\*Apache Tomcat 10.1.57\*\*.



Tomcat permite ejecutar el Servlet y servir la aplicación web mediante HTTP.



9.4 MySQL



La aplicación utiliza MySQL como sistema gestor de base de datos.



La conexión se realiza mediante JDBC desde la clase:



`Conexion.java`



La aplicación utiliza la base de datos:



`aprendizweb`



y la tabla:



`aprendiz`



La clase `AprendizDAO` utiliza `PreparedStatement` para ejecutar la operación de inserción de los registros.



9.5 Entorno de pruebas



Las pruebas automatizadas se ejecutan mediante Maven utilizando JUnit 5.



El comando utilizado fue:



```text

mvn clean test



El resultado obenido fue: 
Tests run: 5, Failures: 0, Errors: 0, Skipped: 0

BUILD SUCCESS

Esto permite comprobar que las pruebas impleentadas se ejecutan correctamente.

---



11\\. Pruebas realizadas



Para comprobar el funcionamiento de los componentes principales del sistema se implementaron pruebas automatizadas utilizando JUnit 5.



11.1 Prueba del modelo



La clase:



`AprendizTest.java`



verifica el comportamiento básico de la clase `Aprendiz`, incluyendo la asignación y recuperación de los datos mediante sus métodos `get` y `set`.



Se realizaron cuatro pruebas sobre el modelo.



11.2 Prueba del acceso a datos



La clase:



`AprendizDAOTest.java`



realiza una prueba relacionada con el almacenamiento de información mediante `AprendizDAO`.



Esta prueba permite comprobar que la aplicación puede establecer comunicación con MySQL y realizar correctamente la operación de persistencia.



\\### 11.3 Resultado de las pruebas



La ejecución mediante Maven produjo el siguiente resultado:



```text

Tests run: 5

Failures: 0

Errors: 0

Skipped: 0

BUILD SUCCESS

13. Buenas prácticas aplicadas



Durante el desarrollo se tuvieron en cuenta las siguientes prácticas:



Utilización de nombres de paquetes relacionados con la responsabilidad de cada componente.

Separación entre modelo, controlador, vista y acceso a datos.

Uso de comentarios y documentación Javadoc en las clases principales.

Uso de PreparedStatement para las operaciones SQL.

Uso de try-with-resources para administrar recursos de conexión.

Uso de Maven para administrar las dependencias.

Implementación de pruebas automatizadas con JUnit 5.

Uso de Git para mantener un historial de cambios.

Utilización de .gitignore para evitar incluir archivos generados como target/.



\\---



14\\. Evidencias del desarrollo



Como soporte del desarrollo del proyecto se pueden presentar las siguientes evidencias:



1\\. Estructura de paquetes y archivos del proyecto.

2\\. Código fuente de `Aprendiz.java`.

3\\. Código fuente de `AprendizServlet.java`.

4\\. Código fuente de `AprendizDAO.java`.

5\\. Formulario web de registro funcionando.

6\\. Registro almacenado correctamente en MySQL.

7\\. Ejecución de las pruebas automatizadas mediante Maven.

8\\. Resultado de las pruebas con cinco pruebas ejecutadas correctamente.

9\\. Historial de commits del proyecto mediante Git.

10\\. Repositorio remoto del proyecto en GitHub.



\\---



15\\. Conclusiones



El desarrollo de AprendizWeb permitió integrar diferentes componentes de una aplicación web utilizando Java, Jakarta Servlet, JSP, JDBC y MySQL.



La separación de responsabilidades entre el modelo, la vista, el controlador y el acceso a datos permitió organizar el código de una manera más clara y facilitar su mantenimiento.



La implementación de pruebas automatizadas permitió comprobar el funcionamiento de los componentes principales. Se obtuvieron cinco pruebas ejecutadas correctamente, sin fallos ni errores.



El uso de Maven facilitó la administración de las dependencias y la compilación del proyecto, mientras que Git y GitHub permitieron mantener un control sobre las versiones del código.



Como resultado, se obtuvo una aplicación web funcional capaz de recibir información mediante un formulario, procesarla mediante un Servlet y almacenarla en una base de datos MySQL.



\\---



16\\. Estado actual del proyecto

Despliegue y archivo compilado

La aplicación AprendizWeb se empaqueta mediante Maven como un archivo WAR para su ejecución en Apache Tomcat.

### Archivo compilado

El archivo generado durante el proceso de compilación es:

`target/AprendizWeb.war`

Este archivo fue generado mediante el comando:

-text
mvn clean package

El proceso de compilación finalizó correctamente con el resultado:

BUILD SUCCESS
Servidor de despliegue

La aplicación fue desplegada en:

Apache Tomcat 10.1.57

El archivo AprendizWeb.war fue copiado al directorio webapps del servidor para realizar el despliegue.

URL de acceso

La aplicación puede ser accedida localmente mediante:

http://localhost:8080/AprendizWeb/

Esta URL corresponde al entorno local de desarrollo y pruebas. No corresponde a un servidor público en Internet.

El proyecto se encuentra funcional y cuenta con:



\\- Aplicación web desplegable en Apache Tomcat.

\\- Formulario para registrar aprendices.

\\- Conexión con MySQL mediante JDBC.

\\- Persistencia de registros mediante DAO.

\\- Pruebas automatizadas con JUnit 5.

\\- Configuración Maven para Java 17.

\\- Control de versiones mediante Git.

\\- Repositorio remoto en GitHub.

\\- Documentación técnica del desarrollo.



\\\*\\\*Último commit:\\\*\\\* `acbc914`



\\\*\\\*Mensaje:\\\*\\\* `Agrega pruebas unitarias y mejora configuracion Maven`

Configuración del servidor y base de datos


\---


--- 17 Configuración de MySQL

El proyecto utiliza MySQL como sistema gestor de base de datos.

La conexión de la aplicación se realiza mediante JDBC y utiliza los siguientes parámetros de configuración:

| Parámetro | Configuración |
|---|---|
| Servidor | `localhost` |
| Puerto | `3306` |
| Base de datos | `aprendizweb` |
| Usuario | `root` |
| Tabla principal | `aprendiz` |
| Driver | `com.mysql.cj.jdbc.Driver` |

Por seguridad, la contraseña utilizada para la conexión no se incluye en este documento.

La clase `Conexion.java` es responsable de establecer la conexión con MySQL, mientras que `AprendizDAO.java` utiliza dicha conexión para realizar las operaciones de persistencia.

- 17.1 Configuración de Apache Tomcat

El proyecto se ejecuta mediante Apache Tomcat 10.1.57.

La aplicación se empaqueta como archivo WAR y se despliega dentro del directorio `webapps` de Tomcat.

La aplicación utiliza el puerto HTTP `8080`.

La URL local de acceso es:

`http://localhost:8080/AprendizWeb/`

Durante la prueba de despliegue se verificó que Tomcat iniciara correctamente y que la aplicación pudiera ser cargada desde el navegador.

- 17.2 Entorno de desarrollo

El proyecto utiliza:

- Java 17 como versión de compilación.
- Maven para la gestión del proyecto y compilación.
- MySQL para la persistencia de datos.
- Apache Tomcat 10.1.57 como servidor.
- Git y GitHub para el control de versiones.
- JUnit 5 para las pruebas automatizadas.

- 17.3 Entorno de pruebas

Las pruebas se realizaron en el entorno local utilizando Maven y JUnit 5.

También se verificó manualmente el flujo de registro mediante el navegador y se confirmó posteriormente la persistencia del registro en la base de datos MySQL.

El resultado de las pruebas automatizadas fue:

`Tests run: 5, Failures: 0, Errors: 0, Skipped: 0`

`BUILD SUCCESS`


\---


18. Manual técnico de instalación y ejecución

- 18.1 Requisitos previos

Para ejecutar AprendizWeb se requiere tener instalado:

- Java 17.
- Maven.
- MySQL.
- Apache Tomcat 10.1.57.
- Git, si se desea obtener el proyecto desde el repositorio.

- 18.2 Preparación de la base de datos

1. Iniciar el servicio de MySQL.
2. Crear o disponer de la base de datos `aprendizweb`.
3. Verificar que exista la tabla `aprendiz`.
4. Comprobar que las credenciales configuradas en `Conexion.java` permitan establecer la conexión.

- 18.3 Compilación del proyecto

Desde la carpeta raíz del proyecto ejecutar:

```text
mvn clean package

Si el proceso termina correctamente, Maven genera:

target/AprendizWeb.war
18.4 Despliegue en Tomcat
Detener Tomcat si se encuentra ejecutándose.
Copiar AprendizWeb.war al directorio webapps de Apache Tomcat.
Iniciar Tomcat mediante startup.bat.
Esperar a que el servidor complete su proceso de inicio.
Abrir la aplicación desde el navegador.
18.5 Acceso a la aplicación

La aplicación se encuentra disponible en el entorno local mediante:

http://localhost:8080/AprendizWeb/
18.6 Registro de un aprendiz
Abrir la URL de la aplicación.
Ingresar nombre, apellido, correo y teléfono.
Seleccionar la opción de registrar.
El Servlet procesa la información.
El DAO realiza la operación de almacenamiento.
El sistema muestra el resultado de la operación.
Verificar en MySQL que el registro haya sido almacenado en la tabla aprendiz.
18.7 Ejecución de pruebas

Para ejecutar las pruebas automatizadas desde la carpeta raíz del proyecto utilizar:

mvn clean test

El resultado esperado es:

Tests run: 5
Failures: 0
Errors: 0
Skipped: 0
BUILD SUCCESS
19.8 Verificación del funcionamiento

La instalación y ejecución se consideran correctas cuando:

Tomcat inicia sin errores.
La aplicación carga correctamente.
El formulario permite ingresar información.
El registro es procesado por el Servlet.
El DAO puede comunicarse con MySQL.
El registro aparece en la tabla aprendiz.
Las pruebas automatizadas terminan sin fallos ni errores.
