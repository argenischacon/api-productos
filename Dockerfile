# Usar OpenJDK 21 como imagen base
FROM openjdk:21-jdk-slim

# Establecer directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR del proyecto
COPY target/api-productos-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto 8080
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"] 