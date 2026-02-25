FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

COPY target/EmployeManage-0.0.1-SNAPSHOT.jar2	 app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]