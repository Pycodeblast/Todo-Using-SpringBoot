package com.kaviya.todo.services;

import com.kaviya.todo.dal.Todorepo;
import com.kaviya.todo.model.Todomodel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Todoservice {
    Todorepo repo;

    @Autowired
    public Todoservice(@Qualifier("todoRepo") Todorepo repo){
        this.repo = repo;
        System.out.println("Service constructor");
    }

    public List<Todomodel> getTodoService(){
        System.out.println("get all todo service");
        return repo.getAllTodos();
    }
    public Todomodel createTodoService(Todomodel todoEntry){
        return repo.createTodo(todoEntry);
    }
    public Todomodel updateTodoService(Todomodel todoEntry, String id){
        return repo.updateTodo(todoEntry, id);
    }
    public String deleteTodoService(String id){
        return  repo.deleteTodo(id);
    }
}
