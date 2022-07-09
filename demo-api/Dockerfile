FROM adoptopenjdk/openjdk11:alpine
MAINTAINER Andrew Kang <andrewkang@gmail.com>
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/app.jar
ENTRYPOINT ["java", "-jar", "/usr/app.jar"]
