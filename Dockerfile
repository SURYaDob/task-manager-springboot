# ===========================================
# Task Manager - Render Deployment (with H2)
# ===========================================
# Build Stage
FROM eclipse-temurin:17-jdk-alpine AS builder

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

RUN ./mvnw dependency:go-offline -B -q

COPY src src
RUN ./mvnw package -DskipTests -B -q

# Runtime Stage
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

RUN addgroup -S appgroup && adduser -S appuser -G appgroup

COPY --from=builder /app/target/*.jar app.jar

USER appuser

EXPOSE 8080

ENTRYPOINT ["java", \
    "-jar", "/app/app.jar", \
    "--spring.profiles.active=${SPRING_PROFILES_ACTIVE:-prod}"]
