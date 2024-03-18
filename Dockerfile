FROM clojure:temurin-21-lein-2.11.2-alpine AS build
COPY . /app/
WORKDIR /app/
RUN lein clean && lein deps
RUN lein uberjar

FROM eclipse-temurin:21.0.2_13-jre AS final
COPY --from=build /app/target/uberjar/webservicering-0.1.0-SNAPSHOT-standalone.jar /app/webservicering.jar
COPY config.edn /app/
WORKDIR /app/
ENTRYPOINT [ "java", "-jar", "./webservicering.jar" ]