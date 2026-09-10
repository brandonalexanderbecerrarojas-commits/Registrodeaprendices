&#x20;Documento Técnico

&#x20;GA8-220501096-AA1-EV01

&#x20;Desarrollo de software a partir de la integración de sus módulos componentes



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


