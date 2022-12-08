FROM openjdk:19-alpine
VOLUME /tmp
COPY /target/location-service-*.jar locationservice.jar
COPY src src
COPY Dockerfile Dockerfile
COPY pom.xml pom.xml
ENTRYPOINT ["java", "-jar", "locationservice.jar"]