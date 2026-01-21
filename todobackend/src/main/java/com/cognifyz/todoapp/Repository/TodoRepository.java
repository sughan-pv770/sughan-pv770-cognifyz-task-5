package com.cognifyz.todoapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognifyz.todoapp.Todo;

public interface TodoRepository extends JpaRepository<Todo,Long> {

}
