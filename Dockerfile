FROM openjdk:8u171-jdk
ADD ./target/encurtador-url.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java", "-jar", "/app.jar"]