## Spring Backend Email Verification 
This project is the full implementation of Spring Boot framework with given dependencies:
- Lombok --> Java annotation library which helps to reduce boilerplate code.
- Spring Web --> Builds web, including RESTful, applications using Spring MVC
- Spring Security --> Highly customizable authentication and access-control framework for Spring applications.
- Spring Data JPA --> Persists data in SQL stores with Java Persistence API using Spring Data and Hibernate
- PostgreSQL Driver --> JDBC & R2DBC driver allowing Java programs to connect to PostgreSQL database using standart Java code
- JavaMail Sender --> Send email using Java Mail and Spring Framework's JavaMailSender.

## Project Description

The purpose of this app is to build an entire backend system. People that wants to be system user go through series of registration process and 
once they verify their given email, then they become the application user with the role of user. 

The project aims to:

- leverage spring security with secure endpoints, 
- create app user with some roles, 
- implement user registration with controllers and service, 
- generate verification links that expires after 15 minutes,
- store data in database, and
- send emails .

Most of the business logic for practice purpose and hence can be improved.  


## Diagram

The diagram below illustrates usa case of backend infastrcuture of app. 

All layers are communicating each other and user goes through this flow. 

![Intro Page](https://github.com/gulbalasalamov/spring-backend-email-verification/blob/master/docs/diagram_login_registration_backend.png)

## Documentation
End points:

1. POST http://localhost:8080/api/v1/registration

Following request will create an app user record in the database. Provided email will receive a token link to enable the account.

```json
{
    "firstName": "Daria",
    "lastName": "Mik",
    "email": "daria@gmail.com",
    "password": "password"
}
```
To confirm, a request received and added to database, connect to database and run query SELECT * FROM which will return us:

 ![appuser in table](https://github.com/gulbalasalamov/spring-backend-email-verification/blob/master/docs/table_app_user_records.png)

Now that post request successfully received and record created in the database, an tokenized email link that will expire after 15 minutes sent to the user.

One of the simple way to test projects' emails with an easy to use web interface that runs on your machine is MailDev, which is a SMTP Server and Web Interface for viewing and testing email during development and used in this project as well. 

MailDev wep app runs  at http://0.0.0.0:1080

Clicking activate button will enable the account.

![login_screen](https://github.com/gulbalasalamov/spring-backend-email-verification/blob/master/docs/login_screen1.png)

To confirm the process , run query to populate list of app user with their all properties. SELECT * FROM app_user;

Notice that initially given user's (Daria) "enabled" property was f (False). After confirmed and authorized, it changed to t (True)

 ![login_screen](https://github.com/gulbalasalamov/spring-backend-email-verification/blob/master/docs/final_table_records.png)
 
 Now login with user credentials provided during registration. If you try to login before authorized, you will get account locked error.

 ![login_screen](https://github.com/gulbalasalamov/spring-backend-email-verification/blob/master/docs/login_screen.png)


2. GET http://localhost:8080/api/v1/registration/confirm

Request parameter -> token

> http://localhost:8080/api/v1/registration/confirm?token=c7d2a42d-1504-4291-a1ff-079c4a6268eb  
  
Alternatively, you can activate your account by GET method. In order for this, include token as request parameter provided as response when you make a POST request 
 
## Running .jar and multiple instance of the app 


Packaging application into .jar, multiple instance of the application can be run. To run another instance of the app, start it in another port. 
  
 > java -jar spring-backend-email-verification-0.0.1-SNAPSHOT --server.port=8082 
 
 ![Intro Page](https://github.com/gulbalasalamov/springboot-web-datajpa-postgresql/blob/master/docs/jar_instances.png)

the .jar file can be accessed from releases: 
https://github.com/gulbalasalamov/spring-backend-email-verification/releases/tag/v1.0


