FROM openjdk:15

ADD /target/oracle_dropwizard_task_app-1.0-SNAPSHOT.jar /data/oracle_dropwizard_task_app-1.0-SNAPSHOT.jar

ADD /src/main/resources/app-configuration.yml /data/app-configuration.yml

WORKDIR /data

RUN java -version

CMD ["java","-jar","oracle_dropwizard_task_app-1.0-SNAPSHOT.jar","server","app-configuration.yml"]

EXPOSE 9090-9091