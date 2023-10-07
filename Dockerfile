# Use a base image with Java and Maven pre-installed
FROM maven:3.9.4-amazoncorretto-21 AS build

# Set the working directory in the container
WORKDIR /app

## Copy the Maven project files and download dependencies

COPY . .

## Build the application
RUN mvn clean package

# Create a lightweight image with only the JAR file
FROM maven:3.9.4-amazoncorretto-21
WORKDIR /app
EXPOSE 8080
COPY --from=build /app/target/swagger-mongodo-reactive-0.0.1-SNAPSHOT.jar ./swagger-mongodo-reactive-0.0.1-SNAPSHOT.jar

# Set the command to run the application
CMD ["java", "-jar", "swagger-mongodo-reactive-0.0.1-SNAPSHOT.jar"]
