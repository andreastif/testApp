package com.test.testapp.service;

import com.test.testapp.model.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {

    Optional<List<Todo>> findAll();
    Optional<Todo> findById(Long id);
    Todo add(Todo todo);

}
