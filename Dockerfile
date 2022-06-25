FROM openjdk:11
    ADD /target/FibonacciApp-1.0-SNAPSHOT.jar /app/FibonacciApp-1.0-SNAPSHOT.jar
    EXPOSE 8080
    ENTRYPOINT ["java","-jar","/app/FibonacciApp-1.0-SNAPSHOT.jar"]