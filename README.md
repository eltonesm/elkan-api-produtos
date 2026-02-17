# elkan-api-produtos

Microservice responsible for product management in Elkan platform.

## 🚀 Tech Stack
- Java 17
- Spring Boot
- MongoDB
- Docker

## ▶️ Running locally

1. Start MongoDB via Docker:
docker run -d --name mongo-elkan -p 27017:27017 mongo:6

2. Run application:
mvn spring-boot:run

Server runs on:
http://localhost:8082

## 🔍 Health Check
http://localhost:8082/actuator/health
