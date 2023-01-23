package com.test.testapp.service;

import com.test.testapp.model.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {

    List<Todo> findAll();
    Optional<Todo> findById(Long id);
    Todo add(Todo newTodo);
    Todo update(Todo updateTodo);
    void deleteById(Long id);
}
