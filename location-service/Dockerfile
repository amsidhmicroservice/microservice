FROM openjdk:19-alpine
VOLUME /tmp
COPY /target/location-service-0.0.4-SNAPSHOT.jar locationservice.jar
COPY src src
COPY Dockerfile Dockerfile
COPY pom.xml pom.xml
ENTRYPOINT ["java", "-jar", "locationservice.jar"]