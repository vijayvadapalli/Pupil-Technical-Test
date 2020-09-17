FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/pupil-technical-test.jar pupil-technical-test.jar
ENTRYPOINT ["sh", "-c", "java -jar /pupil-technical-test.jar"]