FROM openjdk:19-alpine
VOLUME /tmp
COPY /target/person-service-0.0.4-SNAPSHOT.jar personservice.jar
COPY src src
COPY Dockerfile Dockerfile
COPY pom.xml pom.xml
ENTRYPOINT ["java", "-jar", "personservice.jar"]