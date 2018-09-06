FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/SpringBootProject-1.5.10.RELEASE.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /hello-docker-app.jar" ]