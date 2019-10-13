FROM gradle:5.6.2-jdk8
VOLUME /tmp
EXPOSE 8080
ADD build/libs/carpark-api-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Dspring.profiles.active=api","-jar","app.jar"]