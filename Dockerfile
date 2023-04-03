FROM openjdk:19
COPY target/currency-exchange-0.0.1-SNAPSHOT.jar currency-exchange-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/currency-exchange-0.0.1-SNAPSHOT.jar"]