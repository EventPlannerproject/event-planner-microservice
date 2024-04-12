FROM openjdk:17
EXPOSE 8088
ADD target/eventsplanner-0.0.1-SNAPSHOT.jar eventms.jar
ENTRYPOINT ["java","-jar","eventms.jar"]