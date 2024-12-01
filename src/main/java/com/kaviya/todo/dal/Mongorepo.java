package com.kaviya.todo.dal;

import com.kaviya.todo.model.Todomodel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Mongorepo extends MongoRepository<Todomodel, String> {
    // Extends MongoRepository to provide CRUD operations for Todomodel
}
