# RestAPI which exposes and adds shapes

Run com.pupil.technicaltest.ShapeApplication as a Java Application.

Runs on default port of Spring Boot - 8080

Application uses h2 database to run the tests.

## Can be run as a Jar

`mvn clean install` generate a jar
I have also pushed it on to docker hub.
 It can be downloaded from https://hub.docker.com/repository/docker/vadapalli/pupil-technical-test

### Launching the application using Docker

docker container run -p 8080:8080 vadapalli/pupil-technical-test:latest

The following REST URL's are supported

* [Get all Shapes](http://localhost:8080/shapes)
* [Create/Add a new Square (HTTP POST)](http://localhost:8080/square)
        
    - Validations:
        - name should be unique and at least 4 chars long
        - geometryDescription should be at least 5 chars long
        - xCoordinate is a BigDecimal with max 2 fractional values
		- yCoordinate is a BigDecimal with max 2 fractional values
		- length is a BigDecimal with max 2 fractional values

    - Sample json
        - {
          "type": "SQUARE",
          "name": "Square at 50.00 and 50.00",
          "geometryDescription": "Square has equal sides(Only length) and is axis-aligned",
          "xCoordinate": 50,
          "yCoordinate": 50,
          "length": 2
          }


### Security is disabled by default.
 * To enable it just uncomment the following section in pom.xml
 
          <dependency>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-starter-security</artifactId>
         </dependency>
 * Username and password set are as follows
      - spring.security.user.name=pupil
      - spring.security.user.password=test
      

### Have used h2 database and shapedb is the database name used
 * TO access h2 console use
    -  http://localhost:8080/h2-console         
    

Have not normalized the database schema, as it might be better to run on mongodb or anyother nosql database.
Hence kept the schema flat although model is normalized. Used a basic caching mechanisum although can 
be changed to ehcache or other equivalent when needed. 


### Integration tests
    Integration tests are in SquareIntegrationTest.jave. Have tested for the following scenarios.
      - Given a square is at 0,0 coordinates with length of 2. The following scenarious will throw invalid square exception
         * Adding a square of length 2 on bottom left at -1.5, -1.5 coordinates
         * Adding a square of length 2 on top left at -1.5, 1.5 coordinates
         * Adding a square of length 2 on top right at 1.5, 1.5 coordinates
         * Adding a square of length 2 on bottom right at 1.5, -1.5 coordinates
         * Adding a square of length 2 at exact coordinates 0,0 coordinates
      