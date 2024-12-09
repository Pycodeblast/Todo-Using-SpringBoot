package com.kaviya.todo.dal;

import com.kaviya.todo.model.Todomodel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Todorepo {
    public List<Todomodel> getAllTodos() ;
    public Todomodel createTodo(Todomodel todo_entry);
    public Todomodel updateTodo(Todomodel todo_entry, String id);
    public String deleteTodo(String id);
}
