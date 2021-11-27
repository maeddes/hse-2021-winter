package com.example.HelloREST;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Todo {

    @Id
    @GeneratedValue
    long id;

    private String todo;

    public Todo(){}

    public Todo(String todo) {

        this.todo = todo;
        
    }

    public String getTodo() {
        return todo;
    }

}
