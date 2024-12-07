WORKDIR /app
COPY . /app
RUN ./mvnw clean package -DskipTests
EXPOSE 8080
CMD ["java", "-jar", "target/TaskManagerAPI-0.0.1-SNAPSHOT.jar"]