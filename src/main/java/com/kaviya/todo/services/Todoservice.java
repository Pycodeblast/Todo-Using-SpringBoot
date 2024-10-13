package com.kaviya.todo.services;  // Package declaration for the service layer

import com.kaviya.todo.dal.Todorepo;  // Importing the Todorepo interface for database operations
import com.kaviya.todo.model.Todomodel;  // Importing the Todomodel class representing a Todo item
import org.springframework.beans.factory.annotation.Autowired;  // Importing @Autowired for dependency injection
import org.springframework.stereotype.Service;  // Importing @Service annotation to mark this class as a service component

import java.util.List;  // Importing List for storing collections of Todo items
import java.util.Optional;  // Importing Optional to handle possible null values

/**
 * The Todoservice class contains business logic for managing Todo items.
 * It interacts with the Todorepo to perform CRUD operations (Create, Read, Update, Delete).
 */
@Service  // Marks this class as a Spring-managed service component
public class Todoservice {

    private final Todorepo todorepo;  // A reference to the Todorepo for database operations

    /**
     * Constructor for dependency injection.
     * Spring will automatically inject an instance of Todorepo into this class.
     *
     * @param todorepo An instance of Todorepo injected by Spring
     */
    @Autowired  // Indicates that this constructor should be used for dependency injection
    public Todoservice(Todorepo todorepo) {
        this.todorepo = todorepo;  // Assigning the injected Todorepo to the local reference
    }

    /**
     * Retrieves a list of all Todo items from the database.
     *
     * @return A list of Todomodel objects representing all Todo items
     */
    public List<Todomodel> getAllTodos() {
        return todorepo.findAll();  // Calls the findAll method from Todorepo to fetch all todos
    }

    /**
     * Retrieves a specific Todo item by its ID.
     *
     * @param id The ID of the Todo item to retrieve
     * @return An Optional containing the Todo item if found, or empty if not found
     */
    public Optional<Todomodel> getTodoById(String id) {
        return todorepo.findById(id);  // Calls the findById method from Todorepo
    }

    /**
     * Creates a new Todo item in the database.
     *
     * @param todomodel The Todo item to create
     * @return The created Todomodel object after saving
     */
    public Todomodel createTodo(Todomodel todomodel) {
        return todorepo.save(todomodel);  // Calls the save method from Todorepo to create a new todo
    }

    /**
     * Updates an existing Todo item in the database.
     *
     * @param id The ID of the Todo item to update
     * @param todomodel The new data for the Todo item
     * @return The updated Todomodel object, or null if the Todo item was not found
     */
    public Todomodel updateTodo(String id, Todomodel todomodel) {
        Optional<Todomodel> existingTodo = todorepo.findById(id);  // Retrieve the existing Todo by ID
        if (existingTodo.isPresent()) {  // Check if the Todo item exists
            Todomodel updatedTodo = existingTodo.get();  // Get the existing Todo item
            updatedTodo.setTitle(todomodel.getTitle());  // Update the title
            updatedTodo.setDescription(todomodel.getDescription());  // Update the description
            return todorepo.save(updatedTodo);  // Save the updated Todo item
        }
        return null;  // Return null if the Todo item was not found
    }

    /**
     * Deletes a Todo item by its ID.
     *
     * @param id The ID of the Todo item to delete
     */
    public void deleteTodoById(String id) {
        todorepo.deleteById(id);  // Calls the deleteById method from Todorepo to delete the Todo item
    }
}

//Your current design using Todorepo directly is simple and appropriate for your needs.
//Use Mongorepo only when you need to abstract over multiple repositories or swap implementations dynamically.