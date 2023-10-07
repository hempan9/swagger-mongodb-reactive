# swagger-mongodb-reactive
This application is example of reactive controllers using spring boot reactive core library with OPENAPI 3 standard api documentation
# Requirements
1. Maven
2. Java 21
3. MongoDB
4. Docker(Optional)
### 1. Running Application Locally
Once you have installed Maven, Java, MongoDB installed.

Also, change the application.yml file mongoDB connection string 

`mongo:
    database:
        uri: mongodb://mongo:27017`

Build application:

    mvn clean install

Run application:

    mvn spring-boot:run

### 2. Running Application using docker
Once you have docker installed. Go to application root and run following command
which will pull the images for maven, java21 and mongodb and run containers.

    docker compose -d  up

### 3. Accessing the APIs
You can access the swagger api documentation using following links once app is up.

    http://localhost:8080/swagger-ui.html

For the swagger-api docs use following link.

    http://localhost:8080/api-docs

This command will download the maven, mongodb and java21 from dockerhub
and build the application and start container
### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.4/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.4/gradle-plugin/reference/html/#build-image)
* [Spring Data Reactive MongoDB](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#data.nosql.mongodb)
* [Spring Reactive Web](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#web.reactive)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)
* [Building a Reactive RESTful Web Service](https://spring.io/guides/gs/reactive-rest-service/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

