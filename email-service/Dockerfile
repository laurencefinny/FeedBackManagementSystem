FROM openjdk:8-jdk-alpine
COPY target/email-service-0.0.1-SNAPSHOT.jar email.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom -Djava.net.preferIPv4Stack=true","-jar","/email.jar"]