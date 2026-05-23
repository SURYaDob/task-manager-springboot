# 📋 Task Manager Web Application

A full stack Task Management web application built with Java, Spring Boot, MySQL and Thymeleaf.

## 🚀 Features
- User Registration and Login with session management
- Add, Edit, Delete Tasks
- Mark tasks as Complete or Pending
- Filter tasks by status (All / Pending / Completed)
- Live stats counter (Total, Pending, Completed)
- Clean and responsive UI
- Protected routes — unauthenticated users redirected to login

## 🛠️ Tech Stack
| Layer | Technology |
|---|---|
| Backend | Java, Spring Boot, Spring MVC, Hibernate |
| Frontend | HTML5, CSS3, Thymeleaf |
| Database | MySQL |
| Tools | Maven, Git |

## 📸 Screenshots
### Login Page
![Login Page](screenshots/login.png)

### Task Dashboard
![Dashboard](screenshots/dashboard.png)

## ⚙️ How to Run Locally

### Prerequisites
- Java 17+
- MySQL
- Maven

### Steps
1. Clone the repository
   git clone https://github.com/SURYaDob/task-manager-springboot.git

2. Create MySQL database
   CREATE DATABASE taskmanager_db;

3. Update application.properties
   spring.datasource.username=root
   spring.datasource.password=YOUR_PASSWORD

4. Run the application
   mvn spring-boot:run

5. Open browser and go to
   http://localhost:8080/login

## 👨‍💻 Author
**Suraj Dobale**
- LinkedIn: linkedin.com/in/yourprofile
- Email: surajdobale29@gmail.com
