#
# Build stage
#
FROM openjdk:17 AS build
COPY . .

#
# Package stage
#
FROM openjdk:17
COPY --from=build /target/mailSender-0.0.1-SNAPSHOT.jar mailSender.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","mailSender.jar"]