FROM openjdk:11

EXPOSE 7070

WORKDIR /StudentApp

COPY target/studentapp-development.jar /StudentApp/studentapp-development.jar

ENTRYPOINT ["java","-jar", "studentapp-development.jar"]