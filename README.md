# 🚀 Spring Boot + PostgreSQL CRUD API (in Hindi)

This repository contains the source code for a **Spring Boot CRUD REST API** with **PostgreSQL Database**.
It is part of the **Learn With Developer** YouTube series on Java Backend Development in Hindi.

🎥 Watch the full tutorial on YouTube: *\[Coming Soon]*

---

## 📌 Features

* Create, Read, Update, Delete (CRUD) operations for User Management
* REST API with Spring Boot
* PostgreSQL as database
* JPA & Hibernate for persistence
* Postman for API testing
* Docker & Docker Compose support

---

## 🛠 Tools & Technologies Used

* **Java 17**
* **Spring Boot 3**
* **Spring Data JPA**
* **PostgreSQL**
* **Gradle**
* **IntelliJ IDEA**
* **Postman**
* **Docker & Docker Compose**

---

## ⚙️ Project Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/learnwithdeveloper/spring-boot-postgresql-crud
   cd spring-boot-postgresql-crud
   ```

2. ## 🐳 Run with Docker Compose (Recommended)

If you don’t want to install PostgreSQL manually, you can use **Docker Compose**.

1. Start containers:

   ```bash
   docker compose up -d
   ```

2. Check running containers:

   ```bash
   docker ps
   ```

   Look for container named **docker-spring-postgres**.

3. Connect to PostgreSQL inside container:

   ```bash
   docker exec -it <container_id> bash
   psql -U postgres
   ```

   ✅ Welcome! Now you are inside the PostgreSQL database.

---

4. Run the Spring Boot application.

---

## 📬 API Endpoints with cURL

### 1️⃣ Create User

```bash
curl -X POST http://localhost:8080/users \
   -H "Content-Type: application/json" \
   -d '{
     "name": "John Doe",
     "email": "johndoe@gmail.com"
   }'
```

### 2️⃣ Get All Users

```bash
curl -X GET http://localhost:8080/users
```

### 3️⃣ Update User

```bash
curl -X PATCH http://localhost:8080/users/{userId} \
   -H "Content-Type: application/json" \
   -d '{
     "name": "John Doe Updated Name",
     "email": ""
   }'
```

### 4️⃣ Delete User

```bash
curl -X DELETE http://localhost:8080/users/{userId}
```

## 🧪 Import Postman Collection

We have already included the Postman Collection file in this repo:
**`Spring Boot Crud Using PostgreSql.postman_collection.json`**

Follow these steps:

1. Open **Postman**.
2. Click on **Import** (top-left corner).
3. Select the file → `Spring Boot Crud Using PostgreSql.postman_collection.json`.
4. Done ✅ Now you can directly test APIs without writing cURL.

## 📢 Next in the Series

In the upcoming tutorials, we will cover:

* 📑 **Pagination & Sorting** in Spring Boot REST APIs
* 🔍 **Search functionality** for flexible queries
* ✅ **Payload Validation** using `@Valid`, `@NotBlank`, etc.
* 📌 REST API Best Practices
