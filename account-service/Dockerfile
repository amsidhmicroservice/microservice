FROM openjdk:19-alpine
VOLUME /tmp
COPY /target/account-service-*.jar accountservice.jar
COPY src src
COPY Dockerfile Dockerfile
COPY pom.xml pom.xml
ENTRYPOINT ["java", "-jar", "accountservice.jar"]