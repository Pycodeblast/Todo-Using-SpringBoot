package com.kaviya.todo.dal;

import com.kaviya.todo.model.Todomodel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MongoTodoRepo implements Todorepo{
    @Autowired
    private Mongorepo mrepo;

    @Override
    public List<Todomodel> getAllTodos() {
        System.out.println("Get repo:");
        return mrepo.findAll();
    }

    public Todomodel createTodo(Todomodel todo_entry){
        return mrepo.save(todo_entry);
    }

    @Override
    public Todomodel updateTodo(Todomodel todo_entry, String id) {
        Todomodel oldEntry = mrepo.findById(id).get();
        oldEntry.setTitle(todo_entry.getTitle());
        oldEntry.setDescription(todo_entry.getDescription());
        return mrepo.save(oldEntry);
    }

    @Override
    public String deleteTodo(String id) {
        mrepo.deleteById(id);
        return "Deleted Successfully";
    }
}
