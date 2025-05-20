FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy your fat JAR
COPY target/MVP-BookingSystem-0.0.1-SNAPSHOT.jar app.jar

# Expose the port you want the container to listen on
EXPOSE 8090

# Override Spring’s default port and bind to all interfaces
ENTRYPOINT ["java", "-jar", "app.jar", \
            "--server.port=8090", \
            "--server.address=0.0.0.0"]
