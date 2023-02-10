FROM amazoncorretto:11-alpine-jdk 
MAINTAINER JB
COPY target/jb-0.0.1-SNAPSHOT.jar jb-app.jar
ENTRYPOINT ["java","-jar","/jb-app.jar"]
