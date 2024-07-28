# Sorting Algorithms Web Application

## Overview

The Sorting Algorithms Web Application is a Spring Boot-based project designed to demonstrate the integration of various sorting algorithms within a web application. 
## Project Structure

- `org.amalitech.sortingalgorithms`
    - `SortingAlgorithmsApplication`: Main entry point of the application.
    - `config`: Contains configuration classes (`AppConfig`).
    - `controllers`: Contains the web controller (`SortingWebController`).
    - `dto`: Contains data transfer objects (`SortRequest`).
    - `services`: Contains service-related classes and interfaces (`SortingAlgorithm`, `SortingService`, `SortingImplementation`).
    - `resources/templates`: Contains Thymeleaf templates for the web interface.

## Project Objectives

- Develop a Spring-based web application utilizing modules, dependency injection, autowiring, and application context.
- Implement and integrate various sorting algorithms (Heap Sort, Quick Sort, Merge Sort, Radix Sort, and Bucket Sort) for data processing within the application.

## Setup Instructions

### Prerequisites

- Java 21
- Maven (for managing dependencies and building the project)
- IDE (e.g., IntelliJ IDEA, Eclipse)
- Spring Boot

### Step-by-Step Guide

1. **Clone the Repository**

   ```bash
   git clone https://github.com/Ivan-Muhumuza/servletsApi-and-springSortingAlgorithms.git
   cd SortingAlgorithms
   ```

2. **Build the Project**

   Ensure you have Maven installed, then run the following command to build the project and download dependencies:

   ```bash
   mvn clean install
   ```

3. **Run the Application**

   Use your IDE to run the `SortingAlgorithmsApplication.java` file located in the root package (`org.amalitech.sortingalgorithms`).

4. **Access the Web Interface**

   Open your web browser and navigate to `http://localhost:8080` to access the web interface.

## Usage

### User Interface

The application uses Thymeleaf to provide a user-friendly web interface. The main features include:

- **Sorting Operations**: Select a sorting algorithm and input a dataset to sort.
- **Display Results**: View the sorted dataset after executing the selected sorting algorithm.

### Core Functionalities

- **Configuration (`AppConfig.java`)**:
    - Configures Spring beans and application context.

- **Controllers (`SortingWebController.java`)**:
    - Manages web requests and responses.
    - Provides endpoints for selecting sorting algorithms and sorting datasets.

- **Data Transfer Object (`SortRequest.java`)**:
    - Encapsulates the dataset and sorting algorithm selected by the user.

- **Services**:
    - **Enum (`SortingAlgorithm.java`)**: Lists the available sorting algorithms.
    - **Interface (`SortingService.java`)**: Defines the contract for sorting services.
    - **Implementation (`SortingImplementation.java`)**: Implements the sorting algorithms and the sorting service interface.
