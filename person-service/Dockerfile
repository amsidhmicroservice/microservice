FROM openjdk:19-alpine
VOLUME /tmp
COPY /target/person-service-*.jar personservice.jar
COPY src src
COPY Dockerfile Dockerfile
COPY pom.xml pom.xml
ENTRYPOINT ["java", "-jar", "personservice.jar"]