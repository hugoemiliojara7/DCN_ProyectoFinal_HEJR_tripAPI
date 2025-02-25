FROM docker.io/openjdk:17-oracle
LABEL maintainer="Hugo Emilio Jara Rivera <hugoejara7@gmail.com>"
EXPOSE 8080
ARG MONGODB_USERNAME
ARG MONGODB_PASSWORD
ARG JAR_FILE=target/*.jar
COPY target/tripAPI-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "/app.jar"]
