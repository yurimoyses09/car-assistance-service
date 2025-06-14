# Etapa 1: Build
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
# Copia o pom e o src
COPY pom.xml .
COPY src ./src
# Realiza o package SEM os testes
RUN mvn clean package -DskipTests

# Etapa 2: Runtime
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
# Copia o artefato gerado pelo Maven
COPY --from=build /app/target/*.jar app.jar
# Expoe a porta da aplicação
EXPOSE 8080
# Executa a aplicação
ENTRYPOINT ["java","-jar","app.jar"]