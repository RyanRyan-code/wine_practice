
FROM openjdk:17



COPY . /usr/src/myapp

WORKDIR /usr/src/myapp



CMD ["java", "-jar", "./demo/build/libs/demo-0.0.1-SNAPSHOT.jar"]