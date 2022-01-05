FROM openjdk:11
VOLUME /tmp
ADD build/libs/*.jar image.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "image.jar"]