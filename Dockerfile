# Etapa 1: Build usando JDK 25 oficial e instalando o Maven
FROM eclipse-temurin:25-jdk AS build
WORKDIR /app

# Instala o Maven dentro do container
RUN apt-get update && apt-get install -y maven

# Copia e compila o projeto de notificação
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Execução leve usando apenas o JRE 25 na porta 8081
FROM eclipse-temurin:25-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
