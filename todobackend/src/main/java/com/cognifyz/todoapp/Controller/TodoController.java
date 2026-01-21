package com.cognifyz.todoapp.Controller;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.cognifyz.todoapp.Todo;
import com.cognifyz.todoapp.Service.TodoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity<Todo> createtodo(@RequestBody Todo todo){
        return new ResponseEntity<>(todoService.createTodo(todo),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos(){
        return new ResponseEntity<>(todoService.getAllTodos(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id){
        return new ResponseEntity<>(todoService.getTodoById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id){
        todoService.deleteTodo(id);
    }

    @DeleteMapping("/all")
    public void deleteAllTodos(){
        todoService.deleteAllTodos();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo todo){
        return new ResponseEntity<>(todoService.updateTodo(id, todo), HttpStatus.OK);
    }

}
