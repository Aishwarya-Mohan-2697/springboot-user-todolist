# Spring Boot User To-Do List

A simple yet powerful to-do list application built with Spring Boot and Java. This project demonstrates core Spring Boot concepts including user authentication, JWT token-based authorization, and RESTful API design with PostgreSQL database integration.

## Project Overview

This application allows authenticated users to manage their personal to-do lists. Users can create, retrieve, update, and delete tasks through secure API endpoints. The project is designed to help beginners learn Spring Boot fundamentals in a practical, real-world scenario.

## Key Features

- **User Authentication**: Secure user login and registration
- **JWT Token-Based Authorization**: Stateless authentication using JWT tokens for subsequent API calls
- **Task Management**: 
  - Create new tasks
  - Retrieve all tasks for an authenticated user
  - Update existing tasks
  - Delete tasks
- **Field Validations**: Validations have been added to fields to sanitize the user input
- **User-Specific Data**: Each user can only access and manage their own tasks
- **RESTful API**: Clean and intuitive API endpoints

## Technology Stack

- **Backend Framework**: Spring Boot
- **Programming Language**: Java
- **Database**: PostgreSQL
- **Authentication**: JWT (JSON Web Tokens)
- **Build Tool**: Maven 

## Prerequisites

Before you begin, ensure you have the following installed:
- Java 17 or higher
- PostgreSQL
- Maven 4.0+ 
- Git

