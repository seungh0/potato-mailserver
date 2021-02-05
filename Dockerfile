FROM adoptopenjdk/openjdk11:alpine-slim AS BUILD
ENV APP_HOME=/usr/app
WORKDIR $APP_HOME
COPY . $APP_HOME
RUN ./gradlew clean build

FROM adoptopenjdk/openjdk11:alpine-jre
ENV APP_HOME=/usr/app
COPY --from=BUILD  $APP_HOME/build/libs/potato-0.0.1.jar /app.jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "app.jar"]