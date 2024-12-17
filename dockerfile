# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built Spring Boot .jar file into the container at /app
# Replace 'your-app.jar' with the actual name of your jar file (e.g. 'my-spring-boot-app.jar')
COPY /build/libs/usermangementservice-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the app will run on (default Spring Boot port is 8080)
EXPOSE 8080
#Expose 3306

# Command to run the app
ENTRYPOINT ["java", "-jar", "app.jar"]

# Optionally, you can add a health check to ensure your app is running
# HEALTHCHECK CMD curl --fail http://localhost:8080/actuator/health || exit 1
