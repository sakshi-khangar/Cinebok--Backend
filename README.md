# 🎬 CineBok – Movie Ticket Booking Backend

CineBokk Backend is a full-stack movie ticket booking system built using Java Spring Boot and MySQL. It provides secure REST APIs for authentication, movie management, bookings, events, payments, and user management.

## ✨ Features

- User Registration & Login
- JWT Authentication
- Movie Management (CRUD)
- Event Management
- Ticket Booking System
- Razorpay Payment Integration
- User Profile Management
- REST API Architecture
- MySQL Database Integration

## 🛠 Tech Stack

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL
- JWT
- Maven
- Razorpay

## ⚙️ Installation

Clone the repository:

```bash
git clone <repo-url>
```

Move into project:

```bash
cd Cinebokk
```

Run application:

```bash
mvn spring-boot:run
```

Backend runs on:

```text
http://localhost:8080
```

## 🗄 Database

Configure in:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/Cinebok
spring.datasource.username=your_username
spring.datasource.password=your_password
```

## 📡 API Modules

- Authentication
- Movies
- Events
- Bookings
- Payments
- Users

## 🚀 Deployment

Backend ready for deployment on Render.

## 👩‍💻 Author

Sakshi Khangar
