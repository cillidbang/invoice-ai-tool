FROM eclipse-temurin:25-jre

COPY build/libs/invoice-scanner-0.0.1-SNAPSHOT.jar invoice-scanner-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "invoice-scanner-0.0.1-SNAPSHOT.jar"]