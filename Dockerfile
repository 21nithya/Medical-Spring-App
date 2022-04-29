FROM openjdk: 17-jdk
VOLUME /tmp
COPY target /*.jar app.jar
ENTRYPOINT ["java","-java","/app.jar"]
