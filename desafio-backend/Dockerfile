FROM openjdk:8-jdk-alpine as build
WORKDIR /workspace/app

RUN chmod 777 mvnw
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src


WORKDIR /workspace/app-server
COPY . .
RUN mvn clean install
CMD mvn spring-boot:run