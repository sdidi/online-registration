
# Project Requirements:

Develop an Online Registration Application which enables the submission of a form.
The form must capture the following fields:

• A Person’s Full Name
• A Person’s ID Number

The form must be submitted to a backend Restful API based service to be:

• Validated
• Persisted in memory

Invalid data should not be persisted.
Develop an online report to retrieve all the submitted forms and display them.
Write tests if applicable.

Online form and report can be developed using one of the following tech stacks:

• Angular
• VueJs
• ReactJs

Backend service must be developed in Java (Version 8 or later)
The source code and instructions to build and run the system should be committed into a single
Git-based repository using Gitlab, accessible for us clone and review.
You may use any online resources as a reference to complete this task but do not copy code.
Please email the URL to your Git repository once you complete the application in the agreed
timeframe.

# Solution Specification:

## Back-end Restful API 
The backend has been implemented using SpringBoot with Spring Data, and supporting libraries such as the following:
Spring security, Lombok, Swagger OpenAPI for API documentation.

### OpenAPI Specification
This project uses Swagger to document the APIs and this enables easy testing of the end points and to visual the models. To access this we use the the following links:
http://localhost:8080/swagger-ui/index.html , expanded to http://localhost:8080/swagger-ui/index.html#/applicant-controller. 
Can then select any of the 5 endpoints and tryit out and execute. 


### Unit and Integration Test
Unit tests and Integration tests have been done using JUnit5 and Mockito. Tested the service and controller layer.

### Database 

This project uses MySQL database to store entities. The schema used and configurations are given in the application.properties file.

### Validations

ID validation has been done using Luhn algorithm that is used to validate SA id's. Only SA id is allowed to be persisted 
and the validation is performed on the backend code. Then is handled on the front end where the form is displayed 
with relevant errors. 

Field validations are done on the front end to check if all fields are filled otherwise an error is displayed.

### Exception Handling

Exceptions handling has been done both on the backend and frontend. This checks validity of the input including the Invalid ID handling.

## Frontend implements React JS

This project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

## Available Scripts

In the project directory: online-registration/registrations-app-ui, you can run:

### `npm start`

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in your browser.

#### There are 2 Links: List of Applicants and Add Applicant on the navigation bar. The list has actions:

Update an applicant and Delete an applicant.

### Postman Collection

Included in the repository is the Postman Collection (registrationsAPI-postman-collection.json) with API calls. 
This json file can be download into your workstation and imported into Postman to run the api calls.








