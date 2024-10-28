# OneHub Api

## Description
This is a simple API that allows you to add new Employees. The API is built using Spring Boot and uses an in-memory database to store the list of the Employees.


## Running
By default, the application starts on port 8080. and the Project is using JAVA 21

- I have not included any docker files, assuming that the engineers who will review the code, are able to run the project locally using Gradle (or the IDE) :
```sh
./gradlew bootRun
```

- additionally, assuming this feature will be deployed to stage, so 
## API Endpoints
- The API has the following endpoints:
  - POST /api/v1/employees
  - The API has the following request and response structure:
    - Request:
      ```json
      {
        "title": "Mrs.",
        "firstName": "Jane",
        "surName": "Doe",
        "dateOfBirth": "1990-01-01",
        "address": "1234 Main St, Springfield, IL 62701",
        "gender": "F",
        "email": "Jane.Doe@gmail.com"
      }
      ```  
    - Response (Id of the created Employee if Successfull):
        ```json
        1
        ``` 
## API Documentation
- Frontend Engineers can use the following URL to access the API:
```sh
  http://localhost:8080/swagger-ui/index.html
```
PS: localhost can be replaced with the test environment(stage) host name where the API is deployed.
