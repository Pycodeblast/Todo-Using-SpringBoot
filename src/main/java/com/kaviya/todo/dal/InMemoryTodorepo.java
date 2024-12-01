package com.kaviya.todo.dal;

import com.kaviya.todo.model.Todomodel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryTodorepo implements Todorepo {

    // Concurrent HashMap for thread-safe in-memory storage
    private final Map<String, Todomodel> database = new ConcurrentHashMap<>();

    @Override
    public List<Todomodel> findAll() {
        return new ArrayList<>(database.values());  // Retrieve all Todos from memory
    }

    @Override
    public Todomodel save(Todomodel todo) {
        if (todo == null) {
            throw new IllegalArgumentException("Todo cannot be null");
        }

        if (todo.getId() == null || todo.getId().isEmpty()) {
            todo.setId(generateNewId());  // Generate a new ID if none exists
        }
        database.put(todo.getId(), todo);  // Save the Todo to in-memory storage
        return todo;
    }

    @Override
    public Optional<Todomodel> findById(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
        return Optional.ofNullable(database.get(id));  // Return an Optional for safe handling
    }

    @Override
    public void deleteById(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
        database.remove(id);  // Remove the Todo from memory
    }

    private String generateNewId() {
        return String.valueOf(database.size() + 1);  // Simple method to generate a new ID
    }
}
