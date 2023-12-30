FROM openjdk:17-oracle
VOLUME /tmp
COPY target/gateway_service-0.0.1-SNAPSHOT.jar gateway_service.jar
ENTRYPOINT ["java","-jar","/gateway_service.jar"]