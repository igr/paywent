FROM adoptopenjdk:11-jre-hotspot
LABEL maintainer="oblac@igo.rs"

EXPOSE 8080

COPY ./pwt-boot/target/*.jar app.jar

ENTRYPOINT ["java", "-Xmx2G", "-jar", "app.jar"]
