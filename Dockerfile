FROM eclipse-temurin:17
WORKDIR /app
COPY ./build/libs/*.jar linkareer.jar
CMD ["java", "-Duser.timezone=Asia/Seoul", "-jar", "linkareer.jar"]