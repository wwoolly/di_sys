FROM openjdk:17-jdk-alpine
COPY ./build/libs/crackhash-0.0.1-SNAPSHOT.jar /usr/local/lib/crackhash.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/crackhash.jar"]
EXPOSE 8080