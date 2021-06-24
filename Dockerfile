FROM openjdk:15
WORKDIR /usr/src/myapp
ADD target/demo-0.0.1-SNAPSHOT.jar ./
EXPOSE 8080
EXPOSE 9090
CMD java -jar demo-0.0.1-SNAPSHOT.jar