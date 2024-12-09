package com.kaviya.todo.dal;

import com.kaviya.todo.model.Todomodel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Mongorepo extends MongoRepository<Todomodel, String> {
}
