package com.kaviya.todo.dal; // Package declaration for the data access layer

import com.kaviya.todo.model.Todomodel; // Importing the Todomodel class for the entity type

import org.springframework.data.mongodb.repository.MongoRepository; // Importing MongoRepository for CRUD operations

import org.springframework.stereotype.Repository; // Importing Repository annotation to indicate a DAO

// @Repository annotation indicates that the Todorepo interface is a data access component,
// marking it as part of the repository layer. This allows Spring to detect the interface during
// component scanning and automatically create an instance of Todorepo, managing its lifecycle
// as a Spring bean.

// The interface supports CRUD operations through inheritance from MongoRepository and
// allows for the definition of custom query methods, promoting a clean separation of concerns.


@Repository // Marks this interface as a repository component for Spring to manage
public interface Todorepo extends MongoRepository<Todomodel, String> {
    // Extends MongoRepository, inheriting built-in CRUD methods for Todomodel with String as ID type
}





// Todorepo extends MongoRepository<Todomodel, String>, inheriting all CRUD operations.
// MongoRepository provides built-in methods like save(), findById(), findAll(), and deleteById().
// These methods handle create, read, update, and delete operations automatically.
// No explicit code is required for CRUD; Spring generates implementations at runtime using reflection.
// The first generic parameter (Todomodel) specifies the entity type, and the second (String) is the ID type.
// This saves time by avoiding boilerplate code and makes the codebase cleaner.
