FROM openjdk:11-jdk
ARG JAR_FILE=build/libs
COPY ${JAR_FILE}/mileage-0.0.1-SNAPSHOT.jar /server.jar
ENTRYPOINT ["java", "-jar", "/server.jar"]