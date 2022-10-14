FROM openjdk:17-ea-11-jdk-slim
VOLUME /tmp
COPY build/libs/review-0.0.1-SNAPSHOT.jar ReviewServer.jar
ENTRYPOINT ["java","-jar","ReviewServer.jar"]