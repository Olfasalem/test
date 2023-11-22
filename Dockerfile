FROM openjdk:17-jdk-slim
VOLUME /app
COPY . .
COPY crowdapp/target/crowdapp-0.0.1-SNAPSHOT.jar /app.jar
CMD ["java","-jar","/app.jar"]
EXPOSE 8080