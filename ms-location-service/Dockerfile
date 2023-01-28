FROM openjdk:19-alpine@sha256:1686909f4ca66f3e13463e2b00a1c53808aa155f81ae9a8aad8f4b89420d91ef
VOLUME /tmp
COPY /target/ms-location-service-*.jar ms-location-service.jar
COPY src src
COPY Dockerfile Dockerfile
COPY pom.xml pom.xml
ENTRYPOINT ["java", "-jar", "ms-location-service.jar"]