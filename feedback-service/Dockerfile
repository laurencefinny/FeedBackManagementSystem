FROM openjdk:8-jdk-alpine
COPY target/feedback-service-0.0.1-SNAPSHOT.jar movie.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom -Djava.net.preferIPv4Stack=true","-jar","/feedback.jar"]