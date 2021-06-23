FROM openjdk:8-jdk-alpine
COPY target/event-report-service-0.0.1-SNAPSHOT.jar event.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom -Djava.net.preferIPv4Stack=true","-jar","/event.jar"]