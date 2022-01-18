
FROM openjdk:17



COPY . /usr/src/myapp

WORKDIR /usr/src/myapp

RUN chmod +x ./wait-for-it.sh

CMD ["./wait-for-it.sh","postgres:5432","--","java", "-jar", "./demo/build/libs/demo-0.0.1-SNAPSHOT.jar"]