# Biblioteca — Microservicio REST

Microservicio de gestión bibliotecaria construido con **Spring Boot 3.4** y
**Java 17**. Expone una API REST para administrar libros y préstamos, con
build automatizado en GitHub Actions.

Forma parte de un conjunto de servicios independientes desarrollados para el
ramo DSY1103 (Duoc UC), cada uno en su propio repositorio y desplegable por
separado: biblioteca, usuario, hospital, hospital-client y salas-bibliotecas.

---

## Stack

- Spring Boot 3.4.4 (`spring-boot-starter-web`)
- Java 17
- Lombok
- Maven (con Maven Wrapper incluido)
- GitHub Actions para integración continua

---

## Arquitectura

Separación clásica en tres capas: el controlador no toca el repositorio, y
toda la lógica pasa por la capa de servicio.

```
src/main/java/com/example/bibliotecaduoc/
├── controller/     LibroController, PrestamoController   → expone la API
├── services/       LibroService, PrestamoService         → lógica de negocio
├── repository/     LibroRepository, PrestamoRepository   → acceso a datos
└── model/          Libro, Prestamo                       → entidades
```

La persistencia es **en memoria**: los repositorios mantienen la colección en
una lista precargada con datos de ejemplo al arrancar. Es deliberado — el
objetivo del servicio es la API y su estructura, no el motor de base de
datos. Reemplazar el repositorio por Spring Data JPA no requiere tocar ni el
controlador ni el servicio.

---

## API

### Libros — `/api/v1/libros`

| Método | Ruta | Descripción |
|---|---|---|
| GET | `/` | Lista todos los libros |
| GET | `/{id}` | Obtiene un libro por su id |
| GET | `/total` | Cantidad total de libros |
| POST | `/` | Registra un libro nuevo |
| PUT | `/{id}` | Actualiza un libro existente |
| DELETE | `/{id}` | Elimina un libro |

Campos de `Libro`: `id`, `isbn`, `titulo`, `editorial`, `fechaPublicacion`,
`autor`.

### Préstamos — `/api/v1/prestamos`

| Método | Ruta | Descripción |
|---|---|---|
| GET | `/` | Lista todos los préstamos |
| GET | `/{id}` | Obtiene un préstamo por su id |
| GET | `/total` | Cantidad total de préstamos |
| POST | `/` | Registra un préstamo nuevo |
| PUT | `/{id}` | Actualiza un préstamo existente |
| DELETE | `/{id}` | Elimina un préstamo |

Campos de `Prestamo`: `id_prestamo`, `id_libro`, `run_solicitante`,
`fecha_solicitud`, `fecha_entrega`, `cantidad_dias`, `multas`.

---

## Ejecución

Requiere JDK 17. No hace falta instalar Maven: el proyecto incluye el wrapper.

```bash
./mvnw spring-boot:run
```

El servicio queda disponible en `http://localhost:8080`.

Ejemplo de consulta:

```bash
curl http://localhost:8080/api/v1/libros
curl http://localhost:8080/api/v1/libros/total
```

### Compilar el empaquetado

```bash
./mvnw clean package
java -jar target/bibliotecaduoc-0.0.1-SNAPSHOT.jar
```

### Tests

```bash
./mvnw test
```

---

## Integración continua

El workflow [`.github/workflows`](.github/workflows) compila el proyecto en
cada push a `main`: checkout, JDK 17 (Temurin) con caché de Maven, y
`mvn package`. Un cambio que rompa la compilación se detecta en el push, no
al clonar.

---

## Licencia

Proyecto académico, Duoc UC.
