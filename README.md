# Microservicios_Spring_Cloud_Netflix_Spring_Boot

* Este proyecto surgió a fin de poner en práctica la interrelación y funcionamiento de varios microservicios en Base de datos diferentes, dos microservicios se comunicarán con una misma base de datos de tipo Postgres de Inmobiliaria (https://github.com/andresWeitzel/db_inmobiliaria_microservicios_postgres), qué es una réplica de la original que he creado y programado (https://github.com/andresWeitzel/db_Inmobiliaria_PostgreSQL) y un Microservicio se comunicará con una base de datos de tipo Mysql para la facturación de Ventas de dicha inmobiliaria ()

* Tutorial : https://www.youtube.com/watch?v=BnknNTN8icw&t=5s

* El Proyecto consta de 4 microservicios, 3 de tipo REST y 1 de tipo servicio de Eureka

```
* Desarrollo de 4 Microservicios
|  |  |  |-----> Microservice EurekaService 
|  |  |--------> Microservice Rest InmuebleService -------------> db_inmobiliaria (Postgres)
|  |-----------> Microservice Rest PropietarioInmuebleService--> db_inmobiliaria (Postgres)
|--------------> Microservice Rest FacturaService --------------> db_facturacion (Mysql)
```


### Tecnologías Implementadas

| **Tecnologías** | **Versión** | **Finalidad** |               
| ------------- | ------------- | ------------- |
| Java |   12.0.2 | JDK |
| Spring Tool Suite 4 | 4.9.0  | IDE |
| Spring Boot |   2.5.4  | Framework |
| Spring Boot Data JPA  | 2.6.3 | Mapeo de objetos y persistenciua en la db |
| Lombok | 1.18.22 | Automatización de Código | 
| Maven |  4.0.0 | Gestor de Proyectos |
| PostMan | 9.4.1 | Test de Apis |
| XAMPP | 3.2.2  | Paquete de Servidores |
| DBeaver | 21.1 | Gestor de Base de Datos |
| Mysql | 10.1.38 | Sistema de Gestión de Bases de Datos |
| PostgreSQL | 13.4 | Sistema de Gestión de Bases de Datos |
| GNU bash / Terminal | 4.4.23  | Bash / Terminal para el manejo e implementación de Git integrado al IDE Eclipse |
| Git | 2.29.1  | Control de Versiones |


</br>

### Descarga y Documentacion de las Tecnologías Implementadas

| **Tecnología**  | **Descarga** | **Documentación** |               
| ------------- | ------------- | ------------- |
| Java-JDK 12 | https://www.oracle.com/java/technologies/javase/jdk12-archive-downloads.html |  https://docs.oracle.com/en/ |
| Spring Tool Suite 4 |https://spring.io/tools | https://spring.io/guides |
| XAMPP | https://www.apachefriends.org/download.html | https://community.apachefriends.org/f/ |
| DBeaver | 	https://dbeaver.io/download/ | 	https://github.com/dbeaver/dbeaver/wiki |
| PostgreSQL | https://www.postgresql.org/download/ | https://www.postgresql.org/docs/current/tutorial.html | 
| Maven Repository | - | https://mvnrepository.com/ | 
| PostMan | https://www.postman.com/downloads/ | https://www.postman.com/product/what-is-postman/ |
| Git  | https://git-scm.com/downloads |  https://git-scm.com/docs |

</br>


### Patrones de Diseño Implementados

| **Patrón de Diseño** | **Finalidad** |               
| ------------- | ------------- |
| DAO | Uso de interfaces entre la aplicación y el almacenamiento de datos. |
| MVC | Separación y Representación de los Datos, Manejo de errores, Escalabilidad, etc  |

</br>

### Dependencias Implementadas

| **Dependencia Maven**  | **Versión** | **Finalidad** |             
| ------------- | ------------- | ------------- |
| mysql-connector | 8.0.21 |  Conexión al SGDB Mysql |
| postgresql-connector | 42.3.1 | Conexión al SGDB PostgreSQL | 
| spring-boot-starter-data-jpa | 2.6.3 | Api de JpaRepository para el manejo de métodos | 
| spring-boot-starter-web | 2.6.3 | Se agrega toda la configuración web automáticamente de Maven a Spring | 
| lombok | 1.18.22 |  Dependencia la automatización de Código |


</br>




<hr>

## ` Documentación y Guía del Proyecto `
#### (Esta Documentación que Desarrollé es para la Creación y Configuración de los Microservicios Desarrollados, Manejo y Dependencias de Maven, Spring Data con Eureka, Spring Booot, Hibernate-JPA, Mysql y PostgreSQL, entre otros usos. Recomiendo Leerla y Realizar todo paso a paso como se indica en la misma. No se explica a detalle el desarrollo de cada Servicio REST por tiempo y redundancia de código, para el desarrollo detallado de una API REST leer el siguiente repositorio https://github.com/andresWeitzel/Api_Rest_Spring_Productos).

</br>

## Indice

#### Sección 1) Microservicio InmuebleService
   
   - [Paso 1) Creación y Configuraciones del Microservicio InmuebleService](#)
  
   - [Paso 2) Desarrollo del Microservicio InmuebleService](#paso-2-otras-configuraciones-del-proyecto)


</br>

## Sección 1) Microservicio InmuebleService

</br>


### Paso 1) Creación y Configuración del Microservicio `InmuebleService`
#### (Solamente se explicará e incluirá código relevante para microservicios, toda explicación y pasos desde cero para una API REST se incluye en otro proyecto..https://github.com/andresWeitzel/Api_Rest_Spring_Productos)


* Creamos y configuramos un Spring Started Proyect ( Name: InmuebleService | Group: com.inmueble.service | Package : com.inmueble.service )
* Desde la configuración del proyecto agregamos las dependencias spring web, spring data jpa, postgresql driver y Lombok

```xml
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
```

</br>


### Paso 2) Desarrollo del Microservicio `InmuebleService`
#### (Solamente se explicará e incluirá código relevante para microservicios, toda explicación y pasos desde cero para una API REST se incluye en otro proyecto..https://github.com/andresWeitzel/Api_Rest_Spring_Productos)




</br>

### 1.1) Creación y Configuracion del Enum `EstadoInmuebleEnum`
* Dentro de la jerarquia de paquetes `com.inmueble.service` creamos el paquete `enums`
* Vamos a crear una clase enumerado para el campo `estado_inmueble_enum` de la base de datos `db_inmuebles_microservicios`
* Dentro del paquete `enum` creamos la clase 
* Agregamos la annotation @Entity para JPA
* Agregamos los tipos de enumerados disponibles para utilizazr de la base de datos..
 ```java
 
 package com.inmueble.service.enums;

import javax.persistence.Entity;

@Entity
public enum EstadoInmuebleEnum {
	VENDIDO, DISPONIBLE, NO_DISPONIBLE, FALTA_INSPECCION;

}

 
 ```

</br>

### 1.2) Creación y Configuracion de la Entidad `Inmueble`

* Dentro de la jerarquia de paquetes `com.inmueble.service` creamos el paquete `entity`
* Dentro del mismo la clase `Inmueble`
* Agregamos la annotation `@Entity` de la clase para JPA 
* Desarrollamos todos los campos privados modelando la tabla inmuebles de la db `db_inmuebles_microservicios`
* Agregamo también `@Id` y `@GeneratedValue(strategy = GenerationType.AUTO) ` para el autoincrement del id de la db, todas anotaciones para JPA
* Luego Agregamos las anotaciones para lombok `@Data` , `@AllArgsConstructor` y `@NoArgsConstructor` , la primera para la generacion de los getters y setters y el resto de metodos, la segunda para los constructores sobrecargados de la Entidad y la tercera para constructor vacio 

 
 ```java
 package com.inmueble.service.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.inmueble.service.enums.EstadoInmuebleEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inmueble {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int idPropietarioInmueble;
	
	private String descripcion;
	
	private EstadoInmuebleEnum  estadoInmuebleEnum;
	
	private double precioInmuebleUsd;
	
	private String direccion;
	
	private String ubicacion;
	
	private String sitioWeb;
	
	
	

}

 
  
 ```

</br>

### 1.3) Creación y Configuracion de la Interfaz `I_InmuebleRepository`

* Dentro de la jerarquia de paquetes `com.inmueble.service` creamos el paquete `repository`
* Dentro del mismo la Interfaz `I_InmuebleRepository`
* Agregamos la annotation `@Repository` de la clase para JPA y heredamos de la interfaz `JpaRepository<InmuebleEntity, Long>` toda la funcionalidad para la creación de los métodos Jpa 
* Desarrollamos todos los métodos abstractos tentativos de uso 
 
 ```java
package com.inmueble.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmueble.service.entity.Inmueble;

@Repository
public interface I_InmuebleRepository extends JpaRepository<Inmueble, Long>{

	public abstract Inmueble findById(int id);
	
	public abstract Inmueble findByIdPropietarioInmueble(int id);
}

  
 ```
 
 </br>

## Sección 9) Uso y Manejo de Git.

</br>

### Uso y Manejo de Git
### Descarga de Git
* Nos dirigimos a https://git-scm.com/downloads y descargamos el versionador
* Como toda aplicacion siguiente.... siguiente....
* IMPORTANTE:NO TENER DBEAVER ABIERTO DURANTE LA INSTALACION, SINO NO RECONOCE EL PATH

### Abrir una Consola de Git (Git Bash) desde Windows
* --> Escribimos Git Bash desde el Buscador de Windows
* --> Desde la consola escribimos el comando cd seguidamente de la ruta del proyecto
* --> Tenemos que tener la ruta del Proyecto y pegarla en el Git Bash
* --> Una vez dentro del Proyecto podremos hacer uso de Git


### Subir el proyecto al repositorio de github desde la consola de git 

#### 1)Creamos un nuevo repositorio en GitHub.

#### 2)Inicializamos nuestro repositorio local .git desde la terminal.
* git init

#### 3)Agregamos lo desarrollado a nuestro repo local desde la terminal.
* git add *

#### 4)Agregamos lo que tenemos en nuestro repo local al área de Trabajo desde la terminal.
* git commit -m "agrega un comentario entre comillas"

#### 5)Le indicamos a git donde se va a almacenar nuestro proyecto(fijate en tu repositorio de github cual es el enlace de tu proyecto(esta en code)).
* git remote add origin https://github.com/andresWeitzel/Microservicios_Spring_Cloud_Netflix_Spring_Boot

#### 6)Subimos nuestro proyecto.
* git push -u origin master


</br>


### Actualización del repositorio del proyecto desde la consola de GIT

#### 1)Visualizamos las modificaciones realizadas en local
* git status

#### 2)Agregamos lo modificado al area de trabajo
* git add *

#### 3)Confirmamos las modificaciones realizadas
* git commit -m "tu commit entre comillas"

#### 4)Sincronizamos y traemos todos los cambios del repositorio remoto a la rama en la que estemos trabajando actualmente.
##### (SOLO SI SE REALIZARON CAMBIOS DESDE OTRA LADO, ej: en github u/o/y un equipo de trabajo)
* git pull https://github.com/andresWeitzel/Microservicios_Spring_Cloud_Netflix_Spring_Boot

#### 5)Enviamos todos los cambios locales al repo en github
* git push https://github.com/andresWeitzel/Microservicios_Spring_Cloud_Netflix_Spring_Boot

#### 6) En casos extremos pisamos todo el repositorio
* git push -f --set-upstream origin master


</br>

