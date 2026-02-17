# Use a specific, supported Maven image with JDK 25
FROM mcr.microsoft.com/openjdk/jdk:25-ubuntu AS maven_build

# Copy your Maven project files to the container
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-XX:MaxRAMPercentage=75.0", "-jar", "app.jar"]