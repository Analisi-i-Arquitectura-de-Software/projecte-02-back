# Backend Project - Spring Boot Application

This repository contains the backend for quePasa, a private chat messaging application. It is built with **Spring Boot** and runs on **Java 21**. The application handles authentication, authorization, and communication with the frontend through REST APIs.

The backend uses a PostgreSQL to store data, and starting the application automatically runs the required services via **Docker Compose**.

## Features

- **Authentication & Authorization:** Manages JWT-based login and registration.
- **REST APIs:** Seamless communication with the frontend application.
- **Spring Boot Framework:** Fast, secure, and scalable backend.
- **Docker Integration:** Easy deployment with Docker Compose.

---

## Prerequisites

### 1. Install Docker Desktop
To run the application, you'll need Docker installed on your machine. Follow these steps:

1. Download **Docker Desktop** for your operating system:
   - [Docker Desktop for Windows](https://www.docker.com/products/docker-desktop/)
   - [Docker Desktop for macOS](https://www.docker.com/products/docker-desktop/)
   - [Docker Desktop for Linux](https://docs.docker.com/desktop/install/linux-install/)

2. Install Docker Desktop and start it.

3. Verify the installation by running the following command in your terminal:
   ```bash
   docker --version
### 2. Install Java 21
Ensure you have Java 21 installed. You can download it from [Oracle JDK](https://www.oracle.com/java/technologies/downloads/). Verify the installation by running:
   ```bash
            java -version
   ```
## Getting started
Follow these steps to set up and run the application:
1. Clone the repository and change directory to the new folder:
   ```bash
   git clone https://github.com/Analisi-i-Arquitectura-de-Software/projecte-02-back.git
   cd projecte-02-back
2. Build the application using Maven:
   ```bash
   mvn clean install
3. Once the build is successful, run the application:
    ```bash
   mvn spring-boot:run
5. The application will start, the server will be available at: http://localhost:8080
   
### API Endpoints
## Authentication Endpoints
   - POST /auth/register : Register a new user.
   - POST /auth/login : Log in an existing user.
   - POST /auth/refresh : Refresh the access token.
## Message Endpoints
   - GET /api/messages/{chatId}/messages : Get messages list for a given chat.
   - POST /api/messages/{chatId}/messages : Send messages inside a given chat.
## Chat Endpoints
   - GET /api/chats : Get unread messages from all chats.
   - POST /api/chats : Create a new chat.
   
## Database model
![image](https://github.com/user-attachments/assets/82ce5bcc-2c2c-4473-9054-db37d994f9c3)

## Use case diagram
![image](https://github.com/user-attachments/assets/1517f37a-d36a-4699-80df-60d0714ce298)

## C4 model

### Context
![image](https://github.com/user-attachments/assets/66828cf8-f3cc-4cb5-bad7-c28cac3de747)

### Containers
![image](https://github.com/user-attachments/assets/2bcb549b-81ff-4222-a02a-dfe9f672722d)

### Components
![image](https://github.com/user-attachments/assets/15304270-2572-49a6-aef6-de8ed40833fb)




   
   
