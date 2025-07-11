# 🦹‍♀️ Supervillains Validation Demo

Welcome to the **Supervillains Demo Project**, where evil plans meet clean code!  
This is a small Spring Boot application created to demonstrate **Java Bean Validation** in both **Entities** and **DTOs**, using a fun supervillain theme.

> 💡 This project was built for a class demonstration on how to implement and use validation in a real-world Spring Boot app.

---

## 🚀 Features

- ✅ Bean Validation using Jakarta Validation (`@NotBlank`, `@Min`, `@Email`, etc.)
- ✅ Automatic validation in controllers with `@Valid`
- ✅ Validation in both:
    - 📦 **DTOs** (user input validation)
    - 🧬 **Entities** (data integrity at persistence level)
- ✅ Custom validation messages
- ✅ Global exception handling for validation errors
- 🦹‍♂️ Supervillain-themed data and structure for a fun learning experience

---

## 📁 Project Structure

```
src/
├── controller/        # API endpoints
├── dto/               # DTOs with validation annotations
├── entity/            # Entities with optional validation
├── service/           # Business logic
├── exception/         # Custom validation error handling
└── SupervillainsDemoApplication.java
```

---

## 🛠️ Tech Stack

- Java 17
- Spring Boot 3+
- Jakarta Bean Validation
- Maven
- Hibernate Validator (default implementation)

---

## 📦 Requirements

- JDK 17+
- Maven

---

## ▶️ How to Run

```bash
git clone https://github.com/morenaperalta/supervillains-demo
cd supervillains-demo
./mvnw spring-boot:run
```

---

## 🧪 Example Endpoints

### 🔹 Supervillain Endpoints

| Method | Endpoint                               | Description                      |
|--------|----------------------------------------|----------------------------------|
| POST   | `/supervillain`                        | Create a new supervillain       |
| GET    | `/supervillain`                        | Get all supervillains           |
| GET    | `/supervillain/{id}`                   | Get a supervillain by ID        |
| GET    | `/supervillain/name/{name}`            | Get a supervillain by name      |
| GET    | `/supervillain/alias/{alias}`          | Get a supervillain by alias     |
| PUT    | `/supervillain/{id}`                   | Update a supervillain           |
| DELETE | `/supervillain/{id}`                   | Delete a supervillain           |

### 🔹 Power Endpoints

| Method | Endpoint                               | Description                      |
|--------|----------------------------------------|----------------------------------|
| POST   | `/power`                               | Create a new power              |
| GET    | `/power`                               | Get all powers                  |
| GET    | `/power/{id}`                          | Get a power by ID               |
| GET    | `/power/name/{name}`                   | Get a power by name             |
| PUT    | `/power/{id}`                          | Update a power                  |
| DELETE | `/power/{id}`                          | Delete a power                  |

> ⚡ Try sending invalid data (missing fields, wrong types, etc.) and watch validation errors in action!

---

## 📥 Postman Collection

You can test all the endpoints with this ready-to-use Postman collection:  
**🔗 [Supervillains Postman Collection](https://morena-8256913.postman.co/workspace/My-Workspace~4ddead80-5e17-474a-89eb-c018daf47430/request/45728131-ccfade03-a525-4705-9090-8ba4439b8eea)** 

---

## 💬 Use Case

This repository was created as part of a **demo lesson** to explain how and why to validate data in Spring Boot applications — and have a little fun with supervillains along the way!

---

## 🦹‍♀️ Author

**Morena Peralta Almada**  
GitHub: [@morenaperalta](https://github.com/morenaperalta)

---

## 🧠 With Great Power...

Comes great responsibility — and that includes validating your data!  
Happy coding, and may your backend always be protected from evil inputs. 💥
