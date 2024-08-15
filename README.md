Library Management System - Documentation
Table of Contents
Introduction
Prerequisites
Installation
Running the Application
API Endpoints
Authentication
Testing
Troubleshooting
Introduction
This documentation provides an overview of the Library Management System, including how to set up, run the application, interact with the various API endpoints, and use the authentication features.

Prerequisites
Java 11 or higher
Maven 3.6.3 or higher
Spring Boot installed
MySQL or any other relational database
Postman or any other API testing tool
Installation
Clone the repository:
bash
Copy code
git clone https://github.com/your-username/library-management-system.git
Navigate to the project directory:
bash
Copy code
cd library-management-system
Configure the database:
Open application.properties or application.yml.
Set your database configurations (URL, username, password).
Install dependencies:
bash
Copy code
mvn clean install
Running the Application
Run the application:
bash
Copy code
mvn spring-boot:run
or
bash
Copy code
java -jar target/library-management-system-0.0.1-SNAPSHOT.jar
The application will start on http://localhost:8080.
API Endpoints
1. BookController
Get All Books

Endpoint: GET /books
Description: Retrieve all books.
Response:
json
Copy code
[
  {
    "id": 1,
    "title": "Book Title",
    "author": "Author Name",
    "isbn": "1234567890",
    "publishedDate": "2023-01-01"
  }
]
Create a Book

Endpoint: POST /books
Description: Add a new book to the library.
Request Body:
json
Copy code
{
  "title": "New Book Title",
  "author": "Author Name",
  "isbn": "1234567890",
  "publishedDate": "2023-01-01"
}
Response:
json
Copy code
{
  "id": 2,
  "title": "New Book Title",
  "author": "Author Name",
  "isbn": "1234567890",
  "publishedDate": "2023-01-01"
}
2. BorrowingController
Borrow a Book
Endpoint: POST /borrow
Description: Borrow a book from the library.
Request Body:
json
Copy code
{
  "bookId": 1,
  "patronId": 1,
  "borrowDate": "2024-08-15"
}
Response: 200 OK
3. LoginController
Authenticate User
Endpoint: POST /login
Description: Authenticate user and generate a JWT token.
Request Body:
json
Copy code
{
  "username": "user",
  "password": "password"
}
Response:
json
Copy code
{
  "token": "jwt-token-string"
}
4. PatronController
Register a Patron
Endpoint: POST /register
Description: Register a new patron in the library.
Request Body:
json
Copy code
{
  "name": "Patron Name",
  "email": "email@example.com",
  "password": "password"
}
Response: 201 Created
Authentication
The application uses JWT (JSON Web Token) for securing certain endpoints. Authentication is required for accessing the BookController and other protected resources.

Steps to Authenticate:
Obtain a Token:

Send a POST request to /login with valid credentials.
The response will include a JWT token.
Use the Token:

For protected endpoints, include the token in the Authorization header.
Example:
bash
Copy code
Authorization: Bearer your-jwt-token
Testing
To run the tests, use the following command:

bash
Copy code
mvn test
The tests include unit tests for controllers and services, ensuring the application works as expected.

Troubleshooting
Common Issues:
Database Connection Error: Ensure your database is running and the credentials in the application.properties are correct.
Port Already in Use: If port 8080 is in use, change the port in application.properties.
