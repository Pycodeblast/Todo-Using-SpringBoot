package com.kaviya.todo.dal;

import com.kaviya.todo.model.Todomodel;
import org.springframework.data.mongodb.repository.MongoRepository;  // For MongoDB operations
import org.springframework.stereotype.Repository;

@Repository
public interface Mongotodorepo extends MongoRepository<Todomodel, String>, Todorepo {
    // Extends MongoRepository to provide MongoDB operations along with custom methods in Todorepo
}
