FROM eclipse-temurin:21-jammy as build
WORKDIR /workspace/app


## Copy neccessary files for building the java project
COPY gradlew .
RUN chmod +x ./gradlew
COPY gradle/wrapper/gradle-wrapper.properties ./gradle/wrapper/gradle-wrapper.properties
COPY gradle/wrapper/gradle-wrapper.jar ./gradle/wrapper/gradle-wrapper.jar

COPY build.gradle .

COPY src src

## Ensure the Gradle Wrapper script is executable
RUN chmod +x ./gradlew

## Use Gradle to build the application using the RUN stanza
RUN ./gradlew build -x test

## need to add a command to run the app here
ENTRYPOINT ["java","-jar","build/libs/app-geojobsearch-0.1.jar"]
