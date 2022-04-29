FROM openjdk: 17-jdk
Volume /tmp
copy target /*.jar app.jar
ENTRYPOINT ["java","-java","/app.jar"]
