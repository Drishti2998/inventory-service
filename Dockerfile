FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/inventory-service.jar inventory-service.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "inventory-service.jar"]
