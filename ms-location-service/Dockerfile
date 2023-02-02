FROM openjdk:8-jdk
VOLUME /tmp
COPY /target/ms-location-service-*.jar ms-location-service.jar
COPY src src
COPY Dockerfile Dockerfile
COPY pom.xml pom.xml
#RUN wget -O apm-agent.jar https://repo1.maven.org/maven2/co/elastic/apm/elastic-apm-agent/1.9.0/elastic-apm-agent-1.9.0.jar
COPY elastic-apm-agent-1.9.0.jar apm-agent.jar
ENTRYPOINT ["java", "-javaagent:/apm-agent.jar", "-jar", "ms-location-service.jar"]