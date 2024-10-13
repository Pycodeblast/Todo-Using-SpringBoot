// Package declaration to organize the class under the "model" package
package com.kaviya.todo.model;

// Importing the @Id annotation to mark a field as the primary key (unique identifier) for MongoDB documents
import org.springframework.data.annotation.Id;

// Importing the @Document annotation to map the class to a specific MongoDB collection
import org.springframework.data.mongodb.core.mapping.Document;


// This annotation marks the class as a MongoDB document mapped to the "todos" collection
@Document(collection = "todos")
public class Todomodel {

    // Marks this field as the primary key (unique identifier) for MongoDB documents
    @Id
    private String id;

    // Stores the title of the to-do item
    private String title;

    // Stores the description or details of the to-do item
    private String description;

    // Getter method to access the 'id' field
    public String getId() {
        return id;
    }

    // Setter method to update the 'id' field
    public void setId(String id) {
        this.id = id;
    }

    // Getter method to access the 'title' field
    public String getTitle() {
        return title;
    }

    // Setter method to update the 'title' field
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter method to access the 'description' field
    public String getDescription() {
        return description;
    }

    // Setter method to update the 'description' field
    public void setDescription(String description) {
        this.description = description;
    }

    // Overriding the toString() method to provide a string representation of the object
    @Override
    public String toString() {
        return "Todomodel{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
