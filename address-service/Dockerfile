FROM openjdk:19-alpine
VOLUME /tmp
COPY /target/address-service-0.0.4-SNAPSHOT.jar addressservice.jar
COPY src src
COPY Dockerfile Dockerfile
COPY pom.xml pom.xml
ENTRYPOINT ["java", "-jar", "addressservice.jar"]