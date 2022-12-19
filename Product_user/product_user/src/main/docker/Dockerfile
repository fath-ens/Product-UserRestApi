FROM openjdk:11.0.9.1-jre-slim
RUN addgroup appgroup && adduser --disabled-password --gecos '' -ingroup appgroup appuser
USER appuser:appgroup

ARG JAR_FILE=target/*.jar
WORKDIR /home/appuser
COPY --chown=appuser:appgroup ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]