
# 📔 JournalApp

A **Spring Boot-based Journal Management REST API** that allows users to securely create, manage, and access their personal journal entries.

## 🚀 Features

* 🔐 User authentication and authorization using **Spring Security**
* 👤 User registration and user management
* 📝 Create, read, update, and delete journal entries
* 🔒 Protected APIs for authenticated users
* 👑 Role-based authorization for admin APIs
* ❤️ Health-check endpoint for application monitoring
* 🗄️ Database integration using **MongoDB**
* 🌐 RESTful API architecture
* 🧪 Unit and integration testing

## 🛠️ Tech Stack

* **Java 17**
* **Spring Boot**
* **Spring Security**
* **Spring Data MongoDB**
* **Maven**
* **REST APIs**
* **JUnit**
* **Git & GitHub**

## 📂 Project Structure

```text
src
└── main
    └── java
        └── com.example.journalApp
            ├── controller
            ├── entity
            ├── repository
            ├── service
            ├── config
            └── JournalApplication.java
```

## 🔑 API Overview

### Public APIs

```http
GET /public/health-check
```

Checks whether the application is running.

```http
POST /public/create-user
```

Creates a new user account.

### Journal APIs

Journal endpoints require authentication.

```http
GET /_journal
POST /_journal
PUT /_journal/{id}
DELETE /_journal/{id}
```

### Admin APIs

Admin-specific endpoints are protected using role-based authorization.

```text
/admin/**
```

## 🔐 Security

The application uses **Spring Security** to protect resources.

* Public endpoints are accessible without authentication.
* User and journal endpoints require authentication.
* Admin endpoints require the `ADMIN` role.
* Passwords are securely handled through Spring Security.

## ⚙️ Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/rheasharma24/journalApp.git
```

### 2. Open the project

Open the project in IntelliJ IDEA or another Java IDE.

### 3. Configure the database

Configure your MongoDB connection in the application's configuration file.

```properties
spring.data.mongodb.uri=YOUR_MONGODB_CONNECTION_STRING
```

> Never commit database credentials, passwords, API keys, or other secrets to GitHub.

### 4. Build the project

```bash
mvn clean install
```

### 5. Run the application

```bash
mvn spring-boot:run
```

The application will start on the configured port.

## 🧪 Testing

Run the test suite using:

```bash
mvn test
```

## 📌 Future Improvements

* [ ] Add Swagger/OpenAPI documentation
* [ ] Add Docker support
* [ ] Improve API validation and exception handling
* [ ] Add pagination and sorting
* [ ] Add production deployment
* [ ] Add more comprehensive test coverage

## 👩‍💻 Author

**Rhea Sharma**

Java Backend Developer | Spring Boot | DSA

---

⭐ If you find this project useful, consider giving it a star!
