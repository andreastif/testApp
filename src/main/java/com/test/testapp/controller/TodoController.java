package com.test.testapp.controller;

import com.test.testapp.model.Todo;
import com.test.testapp.repository.TodoRepository;
import com.test.testapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/todo") //localhost:8080/api/todo
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<Todo>> findAll() {
        Optional<List<Todo>> allTodos = todoService.findAll();
        if (allTodos.isPresent()) {
            return new ResponseEntity<>(allTodos.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping ("{id}")
    public ResponseEntity<Todo> findById(@PathVariable Long id) { //PathVariable nyar upp Path för IDt. T.ex id  '1337' -> localhost:8080/api/todo/1337
        Optional<Todo> todo = todoService.findById(id);
        if (todo.isPresent()) {
            return new ResponseEntity<>(todo.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
