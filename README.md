# ms-reportes — Microservicio de Reportes

Microservicio correspondiente al **caso NovaBank** (Banca digital / fintech) de la **Evaluación Parcial N°2**.

| | |
|---|---|
| **Asignatura** | JVY0101 — Java: Diseño y Construcción de Soluciones Nativas en Nube |
| **Stack** | Spring Boot 3.2.5 · Java 17 · Maven Wrapper · Spring Data JPA · H2 Database |
| **Arquitectura** | Capas (Controller, Service, Repository, Model) |
| **Puerto** | 8087 |

## Responsabilidad (SRP)

Gestiona la generación, consulta y eliminación de reportes de NovaBank, registrando el título, el tipo de reporte, quién lo generó, sus parámetros, la fecha de generación y el estado (GENERADO). Permite filtrar reportes por tipo. Su base de datos es una **H2 en memoria** (`jdbc:h2:mem:novabank_reports_db;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE`), cumpliendo aislamiento de datos por dominio.

## Consola y Persistencia

Al ejecutar el servicio en el puerto `8087`, se puede acceder a la consola de persistencia H2:

- **H2 Console**: `http://localhost:8087/h2-console`
- **JDBC URL**: `jdbc:h2:mem:novabank_reports_db;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE`
- **Usuario**: `sa`
- **Contraseña**: *(en blanco)*

## Endpoints Principales (`/api/reportes`)

| Método | Ruta | Descripción |
|--------|------|-------------|
| POST | `/api/reportes/generar` | Genera un reporte validando título, tipo y generadoPor; asigna fecha de generación y estado GENERADO; responde 201. |
| GET | `/api/reportes` | Lista todos los reportes registrados. |
| GET | `/api/reportes/{id}` | Obtiene un reporte por id; lanza error si no existe. |
| GET | `/api/reportes/tipo/{tipoReporte}` | Lista los reportes de un tipo determinado. |
| DELETE | `/api/reportes/{id}` | Elimina un reporte por id; responde 204 si tuvo éxito. |

## Instrucciones de Clonación, Compilación y Ejecución Local

1. **Clonar el repositorio:**
   ```bash
   git clone <URL_DEL_REPOSITORIO>
   cd ms-reportes
   ```

2. **Compilar y empaquetar con Maven Wrapper:**
   ```bash
   .\mvnw.cmd clean package -DskipTests
   ```

3. **Ejecutar el ejecutable .jar generado:**
   ```bash
   java -jar target/ms-reportes-1.0.0.jar
   ```

## Cómo ejecutar las pruebas

```bash
.\mvnw.cmd test
```
