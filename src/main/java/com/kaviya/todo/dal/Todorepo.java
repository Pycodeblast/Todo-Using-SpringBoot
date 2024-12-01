package com.kaviya.todo.dal;

import com.kaviya.todo.model.Todomodel;
import java.util.List;
import java.util.Optional;

public interface Todorepo {
    List<Todomodel> findAll();  // Method to get all Todo items
    Todomodel save(Todomodel todo);  // Method to save a Todo
    Optional<Todomodel> findById(String id);  // Method to find a Todo by its ID
    void deleteById(String id);  // Method to delete a Todo by its ID
}
