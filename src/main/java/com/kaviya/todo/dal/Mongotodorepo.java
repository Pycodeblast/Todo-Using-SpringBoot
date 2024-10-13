package com.kaviya.todo.dal;  // Package declaration for the data access layer

import org.springframework.beans.factory.annotation.Autowired;  // Importing @Autowired for dependency injection
import org.springframework.stereotype.Repository;  // Importing @Repository annotation to mark it as a repository bean
/**
 * This class handles communication with the MongoDB database for "Todo" items.
 * It uses the Todorepo to perform basic CRUD (Create, Read, Update, Delete) operations.
 * By implementing the Mongorepo interface, it ensures that any class following this structure
 * can act as a repository component.
 */

@Repository  // Marks this class as a repository, allowing Spring to manage its lifecycle
public class Mongotodorepo implements Mongorepo {

    // A final reference to Todorepo, which provides built-in CRUD methods
    private final Todorepo todorepo;

    /**
     * Constructor for dependency injection.
     * Spring will automatically inject an instance of Todorepo into this class.
     */
    @Autowired  // Marks this constructor for dependency injection
    public Mongotodorepo(Todorepo todorepo) {
        this.todorepo = todorepo;  // Assigning the injected Todorepo to the local reference
    }

}
