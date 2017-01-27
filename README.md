# Gateway

## Requirements

- JDK 8
- Maven

## To compile
```
mvn compile
mvn package
```
## To run
```
java -jar target/gateway-0.0.1-SNAPSHOT.jar
```
## To test
```
mvn test
```
## URLs for testing
- For User: http://localhost:8080/user/?id=1
- For Posts of User 1 : http://localhost:8080/user/post/?id=1
- For Merged Posts of User 1 : http://localhost:8080/merged/?id=1
