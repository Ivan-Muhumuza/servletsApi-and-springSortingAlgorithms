# RESTful API with HATEOAS Principles

## Overview

This project involves designing and implementing a RESTful API following HATEOAS principles using servlets, then configuring and deploying the application on an Apache Tomcat web server. The API allows for CRUD operations on a sample dataset and handles HTTP requests and responses properly.

## Project Structure

- `src/main/java/com/servlet/api`: Contains the main classes for the API.
    - `ApiServlet.java`: The servlet class handling HTTP requests and responses.
    - `DataService.java`: The service class managing the dataset and business logic.
- `src/main/webapp`: Contains web resources and configuration files.

## Setup Instructions

### Prerequisites

- Java 21
- Maven (for managing dependencies and building the project)
- Apache Tomcat (for deploying the web application)
- IDE (e.g., IntelliJ IDEA, Eclipse)

### Step-by-Step Guide

1. **Clone the Repository**

   ```bash
   git clone https://github.com/Ivan-Muhumuza/servletsApi-and-springSortingAlgorithms.git
   cd ServletsApi
   ```

2. **Build the Project**

   Ensure you have Maven installed, then run the following command to build the project and download dependencies:

   ```bash
   mvn clean install
   ```

3. **Configure Apache Tomcat**

    - Download and install Apache Tomcat from the [official website](https://tomcat.apache.org/).
    - Copy the generated WAR file from `target/ServletsApi.war` to the `webapps` directory of your Tomcat installation.
    - Start the Tomcat server.

4. **Access the Application**

   Open your web browser and navigate to `http://localhost:8080/ServletsApi`.

## Usage

### API Endpoints

The API supports the following endpoints for CRUD operations on the sample dataset:

- **Create a new entry**
    - **POST** `/api`
    - Request Body: JSON representation of the new entry

- **Retrieve all entries**
    - **GET** `/api`

- **Retrieve a specific entry**
    - **GET** `/api/{id}`

- **Update an entry**
    - **PUT** `/api/{id}`
    - Request Body: JSON representation of the updated entry

- **Delete an entry**
    - **DELETE** `/api/{id}`

### HATEOAS Principles

Each response includes relevant links to related resources, ensuring compliance with HATEOAS principles. For example, a response to a GET request for a specific entry includes links to update or delete that entry.

### Core Functionalities

- **ApiServlet (`ApiServlet.java`)**:
    - Handles HTTP requests and responses.
    - Maps API endpoints to corresponding methods in `DataService`.
    - Constructs HATEOAS-compliant responses.

- **DataService (`DataService.java`)**:
    - Manages the dataset and business logic.
    - Provides methods for creating, reading, updating, and deleting entries.

### Deployment

To deploy updates to your API, rebuild the project using Maven and redeploy the generated WAR file to Tomcat.
