# Cognifyz Task 5

A full-stack **Todo Application** developed as part of **Cognifyz Internship – Task 5**, featuring a **Spring Boot backend** and a **vanilla HTML/CSS/JavaScript frontend**.

---

## 📌 Project Overview

This project demonstrates a complete **CRUD-based Todo application** where users can:

- Add new todo items  
- View all todos  
- Update todo status  
- Delete individual todos  
- Delete all todos  

The frontend communicates with the backend through **REST APIs**.

---

## 🛠 Tech Stack

### Backend
- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

### Frontend
- HTML5
- CSS3
- JavaScript (Fetch API)

---




---

## ⚙️ Backend Setup & Run

### Prerequisites
- Java 17+
- Maven
- MySQL

### Database Configuration
Update `application.properties`:


Run Backend

cd todobackend
mvn spring-boot:run


Backend will run at:

http://localhost:8080


| Method | Endpoint      | Description      |
| ------ | ------------- | ---------------- |
| GET    | `/todos`      | Get all todos    |
| POST   | `/todos`      | Add a new todo   |
| PUT    | `/todos/{id}` | Update todo      |
| DELETE | `/todos/{id}` | Delete a todo    |
| DELETE | `/todos`      | Delete all todos |


Features Implemented

  RESTful API design

  Full CRUD operations

  Frontend–backend integration

  Clean project structure

  Proper Git repository management


Author

Sughan PV
Cognifyz Internship – Task 5


