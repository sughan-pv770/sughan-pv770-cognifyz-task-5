package com.cognifyz.todoapp.Service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cognifyz.todoapp.Todo;
import com.cognifyz.todoapp.Repository.TodoRepository;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;


    public Todo createTodo(Todo todo){
        return todoRepository.save(todo);
    }

    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    public Todo getTodoById(Long id){
        return todoRepository.findById(id).orElse(null);

    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

   
    public void deleteAllTodos() {
        todoRepository.deleteAll();
    }

    public Todo updateTodo(Long id, Todo todo) {
    return todoRepository.findById(id).map(existing -> {
        existing.setTitle(todo.getTitle());
        existing.setCompleted(todo.isCompleted());
        return todoRepository.save(existing);
    }).orElseThrow(() -> new RuntimeException("Todo not found"));
}


}
