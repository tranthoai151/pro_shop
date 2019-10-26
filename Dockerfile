FROM openjdk:8
VOLUME /tmp
ADD target/my-pro-1.0.jar application.jar
ENTRYPOINT exec java -Xmx512M -jar application.jar
