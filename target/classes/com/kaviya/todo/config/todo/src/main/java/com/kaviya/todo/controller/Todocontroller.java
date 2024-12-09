package com.kaviya.todo.controller;

import com.kaviya.todo.model.Todomodel;
import com.kaviya.todo.services.Todoservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Todocontroller {
    @Autowired
    Todoservice tservice;

    @GetMapping("/todos")
    public List<Todomodel> getTodoController(){
        System.out.println("get Controller");
        return tservice.getTodoService();
    }

    @PostMapping("/todo")
    public Todomodel createTodoController(@RequestBody Todomodel todoEntry){
        return tservice.createTodoService(todoEntry);
    }

    @PutMapping("/todo/{id}")
    public Todomodel updateTodoController(@PathVariable String id, @RequestBody Todomodel todoEntry){
        return tservice.updateTodoService(todoEntry, id);
    }

    @DeleteMapping("/todo/{id}")
    public String deleteTodoController(@PathVariable String id ){
        return tservice.deleteTodoService(id);
    }
}
