#
#FROM openjdk:8-jdk-alpine
#VOLUME /tmp
#ARG JAR_FILE
#ADD ${JAR_FILE}  app.jar
##RUN bash -c 'touch /app.jar'
#ENV JAVA_OPTS=" -Xmx256m -Xms128m"
#
#ENV TZ=Asia/Shanghai
#RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && \
#echo $TZ > /etc/timezone
#
#ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]


FROM openjdk:8-jdk-alpine

MAINTAINER Godliang

ARG JAR_FILE

COPY target/serviceDemo-1.0.0.jar app.jar

ENTRYPOINT ["java","-jar", "app.jar"]
