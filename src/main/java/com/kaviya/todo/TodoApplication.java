package com.kaviya.todo;  // Package declaration for the main application

import org.springframework.boot.SpringApplication;  // Importing SpringApplication class
import org.springframework.boot.autoconfigure.SpringBootApplication;  // Importing SpringBootApplication annotation

@SpringBootApplication  // Indicates that this class is a Spring Boot application
public class TodoApplication {

	public static void main(String[] args) {  // Main method - entry point of the application
		SpringApplication.run(TodoApplication.class, args);  // Launches the Spring Boot application
	}
}


//DAL manages data operations.
//Service layer contains business logic.
//Controller layer handles HTTP requests.


//Controller calls methods from the Service Layer.
//Service Layer uses Mongotodorepo to interact with the DAL.
//Mongotodorepo uses Todorepo, which provides built-in CRUD operations via Spring Data MongoDB.