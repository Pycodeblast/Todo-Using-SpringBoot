package com.kaviya.todo.config;

import com.kaviya.todo.dal.InMemoryTodorepo;
import com.kaviya.todo.dal.Mongotodorepo;
import com.kaviya.todo.dal.Todorepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DatabaseConfig {

    @Value("${db.type}")
    private String dbType;  // db.type property to determine which database to use

    @Bean
    @Primary
    public Todorepo todorepo(Mongotodorepo mongoTodorepo, InMemoryTodorepo inMemoryTodorepo) {
        if ("mongo".equalsIgnoreCase(dbType)) {
            return mongoTodorepo;  // Spring will inject the MongoDB repository
        } else {
            return inMemoryTodorepo;  // Return the in-memory repository
        }
    }
}
