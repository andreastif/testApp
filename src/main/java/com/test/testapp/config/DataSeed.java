package com.test.testapp.config;

import com.test.testapp.model.Todo;
import com.test.testapp.repository.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

// https://spring.io/guides/tutorials/rest/

// DATA SEED

// https://www.digitalocean.com/community/tutorials/spring-configuration-annotation
// Spring @Configuration annotation is part of the spring core framework.
// Spring Configuration annotation indicates that the class has @Bean definition methods.
// So Spring container can process the class and generate Spring Beans to be used in the application.

// Kommer köra bönan och seeda in 5 todos när vi kör app

@Configuration
public class DataSeed {

    @Bean
    CommandLineRunner initDatabase(TodoRepository repository) {
        return args -> {
            List<Todo> preDefinedTodosList = List.of(
                    new Todo("Buy milk"),
                    new Todo("Buy newspaper"),
                    new Todo("Buy candy"),
                    new Todo("Buy donuts"),
                    new Todo("Buy coffee")
            );

            repository.saveAll(preDefinedTodosList);
        };
    }

}
