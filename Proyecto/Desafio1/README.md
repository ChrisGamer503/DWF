# Desafio 1 - Book API

This is a REST API built with **Spring Boot** for managing a book catalog for the fictional publisher "Letras Vivas".  
The API allows you to list all books, add a new book, search books by title, and delete books.

---

## Features
- List all books
- Add a new book
- Search books by title
- Delete a book
- Input validation (title, author, publication year)

---

## Technologies
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Lombok
- Validation with `javax.validation` / `jakarta.validation`
- Swagger/OpenAPI (if included)

---

## Requirements
- Java 17 or higher
- Maven 3.8+
- MySQL 8+
- IDE (IntelliJ IDEA, Eclipse, VSCode, etc.)

---

## How to Run

1. Clone the repository:
`git clone https://github.com/ChrisGamer503/DWF.git`
2. Navigate to the project folder:
`cd DWF/Proyecto/Desafio1`
3. Create the database in MySQL:
`CREATE DATABASE bookdb;`
4. Configure database connection in src/main/resources/application.properties:
`spring.datasource.url=jdbc:mysql://localhost:3306/bookdb?useSSL=false&serverTimezone=UTC`
`spring.datasource.username=root`
`spring.datasource.password=root`
`spring.jpa.hibernate.ddl-auto=update`
`spring.jpa.show-sql=true`
`server.port=8080`
`spring.application.name=Desafio1`
5. Build and run the application:
`mvn clean install`
`mvn spring-boot:run`
6. Access the API at:
`http://localhost:8080/api/books`

---

## API Endpoints
Method - Endpoint - Description

GET -	/api/books - List all books

POST - /api/books - Add a new book (JSON body required)

GET - /api/books/search?title={title} - Search books by title

DELETE - /api/books/{id} - Delete a book by ID

---

## Example JSON for POST /api/books

`{`
`  "title": "Clean Code",`
`  "author": "Robert C. Martin",`
`  "publicationYear": 2008`
`}`

