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
![image](https://github.com/user-attachments/assets/c0f15c28-39a9-4aff-aadf-2c129693fff9)

## Use case diagram
![image](https://github.com/user-attachments/assets/962b16ec-9434-4619-acf6-9a578801fa77)

## C4 model

# Context
![image](https://github.com/user-attachments/assets/26802c9d-bf93-4c48-b4fd-fc138c6c0dd2)

# Containers
![image](https://github.com/user-attachments/assets/9f9ad6be-c2da-4c9a-bc92-18883227b039)

# Components
![image](https://github.com/user-attachments/assets/498de9c2-ffde-4304-b3fe-62900d4c7a91)




   
   
