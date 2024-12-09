package com.kaviya.todo.config;

import com.kaviya.todo.dal.InMemoryTodoRepo;
import com.kaviya.todo.dal.MongoTodoRepo;
import com.kaviya.todo.dal.Todorepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Todoconfig {
    @Value("${storage}")
    private String data;

    @Autowired
    private MongoTodoRepo mongoTodoRepo;

    @Autowired
    private InMemoryTodoRepo memoryTodoRepo;

    @Bean(name = "todoRepo")
    public Todorepo todoRepo(){
        if("Database".equals(data)){
            System.out.println("Data:" + data);
            return  mongoTodoRepo;
        }
        return memoryTodoRepo;
    }
}
