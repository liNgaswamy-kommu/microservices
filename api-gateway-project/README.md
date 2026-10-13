# API Gateway - Amazon Clone

A Spring Cloud Gateway WebFlux application registered with Eureka.

## Requirements
- JDK 17 or newer
- Maven 3.9+
- Eureka Server running at `http://localhost:8761/eureka/`

## Open in IntelliJ
1. Extract this ZIP to a folder such as `C:\kls-training-session\Amazon Clone\api-gateway`.
2. In IntelliJ, choose **File > Open** and select this project's `pom.xml` or project folder.
3. Trust the project if prompted and choose **Load Maven Project**.
4. Wait for Maven to download dependencies.
5. Confirm **Project SDK = JDK 17** under **File > Project Structure**.

## Build and run
Open a terminal in the folder containing `pom.xml` and run:

```powershell
mvn -U clean package
mvn spring-boot:run
```

Gateway runs on port 8080.

## Routes
- `/products/**` -> Eureka service ID `PRODUCT-SERVICE`
- `/orders/**` -> Eureka service ID `ORDER-SERVICE`

The service IDs must match the `spring.application.name` values registered by your product and order services. If your names differ, update `application.yml`.

Start Eureka and the downstream services before testing gateway requests. This ZIP contains the project source and Maven configuration; Maven downloads dependencies on the first build, so internet access is required.
