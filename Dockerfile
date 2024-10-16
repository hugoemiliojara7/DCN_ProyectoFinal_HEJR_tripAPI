FROM openjdk:17-oracle
LABEL maintainer="Hugo Emilio Jara Rivera <hugoejara7@gmail.com"
EXPOSE 8080
ARG MONGODB_USERNAME
ARG MONGODB_PASSWORD
ARG JAR_FILE=target/*.jar
COPY target/*.jar app.jar
CMD ["java", "-jar", "/app.jar"]
