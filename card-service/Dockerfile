FROM openjdk:19-jdk-alpine
VOLUME /tmp
COPY /target/card-service-0.0.4-SNAPSHOT.jar cardservice.jar
COPY src src
COPY Dockerfile Dockerfile
COPY pom.xml pom.xml
ENTRYPOINT ["java", "-jar", "cardservice.jar"]