# 📋 Task Manager

A full-stack **task management** web application built with Spring Boot, Thymeleaf, and MySQL. Users can register, log in, and manage their personal tasks with full CRUD operations, status tracking, and due dates.

[![Live Demo](https://img.shields.io/badge/Live%20Demo-Task%20Manager-2ea44f?style=for-the-badge&logo=render)](https://task-manager-springboot-latest.onrender.com)

---

## ✨ Features

### 🔐 User Authentication
- **Session-based authentication** — login, register, and logout with HTTP session tracking
- **Auth interceptor** — protects all `/tasks/` routes, redirects unauthenticated users to login
- **Duplicate email prevention** — registration rejects already-used emails

### 📝 Task Management
- **Full CRUD** — create, read, update, and delete tasks
- **Status tracking** — tasks start as `PENDING` and can be marked `COMPLETED`
- **Due date** — set and edit due dates for each task
- **Filter by status** — view all tasks, or filter by PENDING / COMPLETED
- **Edit tasks** — modify title, description, and due date after creation

### 📊 Dashboard Stats
- **Task counts** — see total, pending, and completed task counts at a glance

---

## 🛠️ Tech Stack

| Layer | Technology |
|-------|-----------|
| **Backend** | Java 17, Spring Boot 4.x |
| **Templating** | Thymeleaf |
| **Database** | MySQL, Spring Data JPA, Hibernate |
| **Security** | Session-based auth with `HttpSession` + `HandlerInterceptor` |
| **Build** | Maven |
| **Deployment** | Render |

---

## 🚀 Getting Started

### Prerequisites

- **Java 17+** (JDK)
- **MySQL 8.0+** (running on port 3306)
- **Maven** (or use the included `mvnw` wrapper)

### 1. Clone & Configure

```bash
git clone https://github.com/SURYaDob/task-manager-springboot.git
cd task-manager-springboot
```

### 2. Create the Database

```sql
CREATE DATABASE IF NOT EXISTS taskmanager_db;
```

### 3. Configure Database Credentials

Edit `src/main/resources/application.properties` to match your MySQL credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/taskmanager_db
spring.datasource.username=root
spring.datasource.password=your_password
```

### 4. Run the Application

```bash
# Development mode
./mvnw spring-boot:run

# Or build and run
./mvnw package -DskipTests
java -jar target/laundry-0.0.1-SNAPSHOT.jar
```

### 5. Access the Application

| Resource | URL |
|----------|-----|
| **Application** | [http://localhost:8080](http://localhost:8080) |

---

## 🧭 Routes

| Method | Path | Description |
|--------|------|-------------|
| `GET` | `/login` | Show login page |
| `POST` | `/login` | Authenticate user |
| `GET` | `/register` | Show registration page |
| `POST` | `/register` | Register new user |
| `GET` | `/logout` | Logout and invalidate session |
| `GET` | `/tasks` | View user's tasks (with optional `?filter=PENDING/COMPLETED`) |
| `POST` | `/tasks/create` | Create a new task |
| `GET` | `/tasks/status/{id}?status=` | Update task status |
| `GET` | `/tasks/delete/{id}` | Delete a task |
| `GET` | `/tasks/edit/{id}` | Show edit task form |
| `POST` | `/tasks/edit/{id}` | Submit task edits |

---

## 📁 Project Structure

```
task-manager-springboot/
├── pom.xml                               # Maven project descriptor
├── mvnw / mvnw.cmd                       # Maven wrapper scripts
├── src/
│   ├── main/
│   │   ├── java/com/suraj/taskmanager/
│   │   │   ├── TaskmanagerApplication.java    # Entry point
│   │   │   ├── AuthInterceptor.java           # Session auth interceptor
│   │   │   ├── WebConfig.java                 # Interceptor registration
│   │   │   ├── controller/
│   │   │   │   ├── AuthController.java        # Login/register/logout
│   │   │   │   └── TaskController.java        # Task CRUD
│   │   │   ├── model/
│   │   │   │   ├── User.java                  # User entity
│   │   │   │   └── Task.java                  # Task entity
│   │   │   ├── repository/
│   │   │   │   ├── UserRepository.java        # User data access
│   │   │   │   └── TaskRepository.java        # Task data access
│   │   │   └── service/
│   │   │       ├── UserService.java           # User business logic
│   │   │       └── TaskService.java           # Task business logic
│   │   └── resources/
│   │       ├── templates/                     # Thymeleaf templates
│   │       │   ├── login.html
│   │       │   ├── register.html
│   │       │   ├── tasks.html
│   │       │   └── edit-task.html
│   │       └── application.properties
│   └── test/
│       └── java/                              # Test code
└── README.md
```

---

## 🧪 Running Tests

```bash
./mvnw test
```

---

## 📄 License

This project is for educational/demo purposes.

---

## 👤 Author

**Suraj Dobale**  
📧 [surajdobale29@gmail.com](mailto:surajdobale29@gmail.com)  
🐙 [github.com/SURYaDob](https://github.com/SURYaDob)  
💼 [linkedin.com/in/suraj-dobale-b713b91a6](https://linkedin.com/in/suraj-dobale-b713b91a6)

---

## 🏷️ Topics

> Suggested GitHub topics for this repository:

`spring-boot` `java` `task-manager` `thymeleaf` `spring-data-jpa` `mysql` `crud` `maven` `cdac` `full-stack` `render-deployment`
