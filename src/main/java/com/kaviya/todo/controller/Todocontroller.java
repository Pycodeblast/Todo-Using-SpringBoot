package com.kaviya.todo.controller;  // Package declaration for the controller layer

import com.kaviya.todo.model.Todomodel;  // Importing the Todomodel class representing a Todo item
import com.kaviya.todo.services.Todoservice;  // Importing the Todoservice for business logic
import org.springframework.beans.factory.annotation.Autowired;  // Importing @Autowired for dependency injection
import org.springframework.http.ResponseEntity;  // Importing ResponseEntity for HTTP responses
import org.springframework.web.bind.annotation.*;  // Importing Spring's web annotations

import java.util.List;  // Importing List for storing collections of Todo items

/**
 * The Todocontroller class handles HTTP requests related to Todo items.
 * It provides endpoints for creating, reading, updating, and deleting Todos.
 */
@RestController  // Marks this class as a RESTful controller
@RequestMapping("/todos")  // Base URL for all endpoints in this controller
public class Todocontroller {

    private final Todoservice todoservice;  // A reference to the Todoservice for business logic

    /**
     * Constructor for dependency injection.
     * Spring will automatically inject an instance of Todoservice into this class.
     *
     * @param todoservice An instance of Todoservice injected by Spring
     */
    @Autowired  // Indicates that this constructor should be used for dependency injection
    public Todocontroller(Todoservice todoservice) {
        this.todoservice = todoservice;  // Assigning the injected Todoservice to the local reference
    }

    // Get all todos
    @GetMapping  // Maps GET requests to this method
    public List<Todomodel> getAllTodos() {
        System.out.println("Fetching all todos...");  // Log the request
        List<Todomodel> todos = todoservice.getAllTodos();  // Fetch all todos using the service
        System.out.println("Fetched " + todos.size() + " todos.");  // Log the number of todos fetched
        return todos;  // Return the list of todos
    }

    // Get a todo by ID
    @GetMapping("/{id}")  // Maps GET requests with a specific ID to this method
    public ResponseEntity<Todomodel> getTodoById(@PathVariable String id) {
        System.out.println("Fetching todo with ID: " + id);  // Log the request
        return todoservice.getTodoById(id)  // Call the service to get the todo by ID
                .map(todo -> {
                    System.out.println("Todo found: " + todo);  // Log the found todo
                    return ResponseEntity.ok().body(todo);  // Return HTTP 200 with the todo
                })
                .orElseGet(() -> {
                    System.out.println("Todo not found for ID: " + id);  // Log if not found
                    return ResponseEntity.notFound().build();  // Return HTTP 404 if not found
                });
    }

    // Create a new todo
    @PostMapping  // Maps POST requests to this method
    public Todomodel createTodo(@RequestBody Todomodel todomodel) {
        System.out.println("Creating a new todo: " + todomodel);  // Log the new todo
        Todomodel createdTodo = todoservice.createTodo(todomodel);  // Create the todo using the service
        System.out.println("Created todo with ID: " + createdTodo.getId());  // Log the created todo ID
        return createdTodo;  // Return the created todo
    }

    // Update a todo
    @PutMapping("/{id}")  // Maps PUT requests with a specific ID to this method
    public ResponseEntity<Todomodel> updateTodo(@PathVariable String id, @RequestBody Todomodel todomodel) {
        System.out.println("Updating todo with ID: " + id);  // Log the update request
        Todomodel updatedTodo = todoservice.updateTodo(id, todomodel);  // Update the todo using the service
        if (updatedTodo != null) {
            System.out.println("Updated todo: " + updatedTodo);  // Log the updated todo
            return ResponseEntity.ok(updatedTodo);  // Return HTTP 200 with the updated todo
        }
        System.out.println("Todo not found for update with ID: " + id);  // Log if not found
        return ResponseEntity.notFound().build();  // Return HTTP 404 if not found
    }

    // Delete a todo
    @DeleteMapping("/{id}")  // Maps DELETE requests with a specific ID to this method
    public ResponseEntity<Void> deleteTodoById(@PathVariable String id) {
        System.out.println("Deleting todo with ID: " + id);  // Log the delete request
        todoservice.deleteTodoById(id);  // Delete the todo using the service
        System.out.println("Deleted todo with ID: " + id);  // Log the deletion
        return ResponseEntity.noContent().build();  // Return HTTP 204 (No Content)
    }
}
