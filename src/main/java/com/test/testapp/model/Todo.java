package com.test.testapp.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private LocalDate created;
    @Column(nullable = false)
    private LocalDate lastUpdated;

    protected Todo() {
    }

    public Todo(String description) {
        this.description = description;
        this.created = LocalDate.now();
        this.lastUpdated = LocalDate.now();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getCreated() {
        return created;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Todo todo)) return false;
        return Objects.equals(id, todo.id) && Objects.equals(description, todo.description) && Objects.equals(created, todo.created) && Objects.equals(lastUpdated, todo.lastUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, created, lastUpdated);
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
