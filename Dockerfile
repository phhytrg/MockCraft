FROM eclipse-temurin:17
#WORKDIR /app
COPY --from=build /target/mockdata.jar mockdata.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/mockdata.jar"]