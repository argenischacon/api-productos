# 🛍️ API de Gestión de Productos

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://openjdk.org/projects/jdk/21/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.3-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-3.9+-blue.svg)](https://maven.apache.org/)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15+-blue.svg)](https://www.postgresql.org/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

API REST completa para la gestión de productos desarrollada con Spring Boot 3.5.3, Java 21 y PostgreSQL. Incluye documentación automática con OpenAPI/Swagger, testing integral con Testcontainers, y reportes de cobertura de código.

## 🚀 Características

- ✅ **CRUD completo** de productos
- ✅ **Validación de datos** con Bean Validation
- ✅ **Documentación automática** con OpenAPI/Swagger
- ✅ **Testing integral** con JUnit 5 y Testcontainers
- ✅ **Reportes de cobertura** con JaCoCo
- ✅ **Monitoreo** con Spring Boot Actuator
- ✅ **Mapeo de objetos** con ModelMapper
- ✅ **Arquitectura en capas** (Controller, Service, Repository)
- ✅ **DTOs** para separación de responsabilidades
- ✅ **Configuración por perfiles** (dev, test, prod)

## 🛠️ Tecnologías

- **Backend**: Spring Boot 3.5.3, Java 21
- **Base de Datos**: PostgreSQL 15+
- **ORM**: Spring Data JPA con Hibernate
- **Testing**: JUnit 5, Testcontainers, H2
- **Documentación**: OpenAPI 3.0 / Swagger UI
- **Build Tool**: Maven 3.9+
- **Monitoreo**: Spring Boot Actuator
- **Cobertura**: JaCoCo

## 📋 Prerrequisitos

- Java 21 o superior
- Maven 3.9+
- PostgreSQL 15+
- Docker (opcional, para Testcontainers)

## 🚀 Instalación y Configuración

### 1. Clonar el repositorio

```bash
git clone https://github.com/tu-usuario/api-productos.git
cd api-productos
```

### 2. Configurar la base de datos

Crear una base de datos PostgreSQL:

```sql
CREATE DATABASE productos;
CREATE USER productos_user WITH PASSWORD 'tu_password';
GRANT ALL PRIVILEGES ON DATABASE productos TO productos_user;
```

### 3. Configurar variables de entorno

Crear un archivo `.env` en la raíz del proyecto:

```env
DB_URL=jdbc:postgresql://localhost:5432/productos
DB_USERNAME=productos_user
DB_PASSWORD=tu_password
```

### 4. Ejecutar la aplicación

```bash
# Compilar y ejecutar
mvn spring-boot:run

# O compilar y ejecutar el JAR
mvn clean package
java -jar target/api-productos-0.0.1-SNAPSHOT.jar
```

La aplicación estará disponible en: `http://localhost:8080`

## 📚 Documentación de la API

### Swagger UI
- **URL**: http://localhost:8080/swagger-ui.html
- **Descripción**: Interfaz interactiva para probar los endpoints

### OpenAPI JSON
- **URL**: http://localhost:8080/api-docs
- **Descripción**: Especificación OpenAPI en formato JSON

## 🔧 Endpoints Disponibles

### Productos

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `GET` | `/api/v1/products` | Obtener todos los productos |
| `GET` | `/api/v1/products/{id}` | Obtener producto por ID |
| `POST` | `/api/v1/products` | Crear nuevo producto |
| `PUT` | `/api/v1/products/{id}` | Actualizar producto |
| `DELETE` | `/api/v1/products/{id}` | Eliminar producto |

### Ejemplo de uso

```bash
# Obtener todos los productos
curl -X GET http://localhost:8080/api/v1/products

# Crear un producto
curl -X POST http://localhost:8080/api/v1/products \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Laptop Gaming",
    "description": "Laptop para gaming de alto rendimiento",
    "price": 1299.99,
    "stock": 10
  }'
```

## 🧪 Testing

### Ejecutar todos los tests

```bash
mvn test
```

### Ejecutar tests con cobertura

```bash
mvn clean test jacoco:report
```

Los reportes de cobertura se generan en: `target/site/jacoco/index.html`

### Ejecutar tests de integración

```bash
mvn verify
```

## 📊 Monitoreo

### Actuator Endpoints

- **Health Check**: http://localhost:8080/actuator/health
- **Info**: http://localhost:8080/actuator/info
- **Metrics**: http://localhost:8080/actuator/metrics

## 🏗️ Estructura del Proyecto

```
src/
├── main/
│   ├── java/com/example/api_productos/
│   │   ├── controller/          # Controladores REST
│   │   ├── service/             # Lógica de negocio
│   │   ├── repository/          # Acceso a datos
│   │   ├── model/               # Entidades JPA
│   │   ├── dto/                 # Objetos de transferencia
│   │   └── ProductosApplication.java
│   └── resources/
│       ├── application.properties
│       ├── application-dev.properties
│       └── application-test.properties
└── test/
    └── java/com/example/api_productos/
        ├── controller/          # Tests de controladores
        ├── service/             # Tests de servicios
        ├── repository/          # Tests de repositorios
        └── config/              # Configuración de tests
```

## 🔧 Configuración por Perfiles

### Desarrollo (`dev`)
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

### Testing (`test`)
```bash
mvn test -Dspring.profiles.active=test
```

### Producción (`prod`)
```bash
java -jar target/api-productos-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod
```

## 📦 Build y Deployment

### Crear JAR ejecutable

```bash
mvn clean package
```

### Crear imagen Docker

```bash
docker build -t api-productos .
docker run -p 8080:8080 api-productos
```

## 🤝 Contribuir

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## 📝 Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE](LICENSE) para más detalles.

## 👥 Autores

- **Argenis ☕** - *Desarrollo inicial* - [argenischacon](https://github.com/argenischacon)

## 🙏 Agradecimientos

- Spring Boot Team por el excelente framework
- PostgreSQL por la base de datos robusta
- Testcontainers por facilitar los tests de integración

## 📞 Soporte

Si tienes alguna pregunta o problema:

- 📧 Email: tu-email@ejemplo.com
- 🐛 Issues: [GitHub Issues](https://github.com/tu-usuario/api-productos/issues)
- 📖 Wiki: [GitHub Wiki](https://github.com/tu-usuario/api-productos/wiki)

---

⭐ **¡No olvides darle una estrella al proyecto si te fue útil!**
