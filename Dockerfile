# Usando uma imagem base do OpenJDK
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho no container
WORKDIR /app

# Copia o JAR gerado para dentro do container
COPY target/youdelivery-0.0.1-SNAPSHOT.jar youdelivery.jar

# Expõe a porta onde a aplicação vai rodar
EXPOSE 8080

# Define o comando para rodar a aplicação Spring Boot
ENTRYPOINT ["java", "-jar", "youdelivery.jar"]