package com.test.testapp.controller;

import com.test.testapp.model.Todo;
import com.test.testapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //Vad skall denna skrivas om till om datat man returnerar är tomt?
    @GetMapping
    public ResponseEntity<List<Todo>> findAll() {
        List<Todo> allTodos = todoService.findAll();
        return new ResponseEntity<>(allTodos, HttpStatus.OK);

    }

    @GetMapping("{id}")
    public ResponseEntity<Todo> findById(@PathVariable Long id) { //PathVariable nyar upp Path för IDt. T.ex id  '1337' -> localhost:8080/api/todo/1337
        Optional<Todo> todo = todoService.findById(id);
        if (todo.isPresent()) {
            return new ResponseEntity<>(todo.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Post (skapa) localhost:8080/api/todo, test m Postman OK (ej swagger)
    @PostMapping
    public ResponseEntity<Todo> addTodo(@RequestBody Todo newTodo) {
        return new ResponseEntity<>(todoService.add(newTodo), HttpStatus.CREATED);
    }

    //LETAR EFTER ID SOM MATCHAR DET SOM SKICKADES IN, DÅ UPPDATERAR DEN OBJEKTET (ANNARS SKAPAR DEN EN NY OM DET INTE FINNS)
    @PutMapping
    public ResponseEntity<Todo> updateTodo(@RequestBody Todo updateTodo) {
        return new ResponseEntity<>(todoService.update(updateTodo), HttpStatus.OK);
    }


    //med eller utan response entity?
    @DeleteMapping("{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteById(id);
    }

    //test/ för att ha två delete mappings
    @DeleteMapping("test/{id}")
    public ResponseEntity<Void> deleteTodoTest(@PathVariable Long id) {
        todoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
