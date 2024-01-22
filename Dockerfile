FROM registry.weintegrator.com/library/openjdk11:11-jre-alpine-a24d4377

ENV TZ=Europe/Moscow

WORKDIR /opt/app
CMD java $JAVA_MEM $JAVA_EXT org.springframework.boot.loader.JarLauncher
EXPOSE 8080
