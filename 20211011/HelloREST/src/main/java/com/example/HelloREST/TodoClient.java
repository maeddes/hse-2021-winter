package com.example.HelloREST;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoClient {

    private Logger logger = LoggerFactory.getLogger(TodoClient.class);

    @Autowired
	TodoRepository repo;

	@PostMapping("/todo/{todo}")
	public String createTodo(@PathVariable String todo){

        logger.info("Received input String: {}", todo);

		Todo newTodo = new Todo(todo);		
		repo.save(newTodo);

        logger.info("Created Todo Entity: {}", todo);

		return null;

	}

    @GetMapping("/todo/")
    public List<String> getTodos(){

        logger.debug("Invoked getTodos");

        ArrayList<String> todos = new ArrayList<String>();

        /*
        Iterator<Todo> todoIterator = repo.findAll().iterator();
        while (todoIterator.hasNext()) todos.add(todoIterator.next().getTodo());

        repo.findAll().forEach(item -> todos.add(item.getTodo()));

        repo.findAll().forEach(todos::add);
         */

        for(Todo item : repo.findAll()) todos.add(item.getTodo());

        logger.info("returning: {}", todos.toString());

        return todos;
    }
    
}
