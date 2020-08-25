package com.springAngular.rest.webservices.springAngularrestwebservices.todo;

import java.net.URI;
import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoResource {

	@Autowired
	private TodoHardcodedService todoservice;

	@GetMapping("/api/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username) {
		return todoservice.findAll();
	}

	@GetMapping("/api/users/{username}/todos/{id}")
	public Todo getTodo(@PathVariable String username, @PathVariable long id) {
		return todoservice.findById(id);
	}

	@DeleteMapping("/api/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {
		Todo todoDeleteById = todoservice.deleteById(id);
		if (todoDeleteById != null) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/api/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id,
			@RequestBody Todo todo) {
		Todo todoUpdated = todoservice.save(todo);
		return new ResponseEntity<Todo>(todoUpdated, HttpStatus.OK);

	}
	
	@PostMapping("/api/users/{username}/todos")
	public ResponseEntity<Void> createTodo(@PathVariable String username,
			@RequestBody Todo todo) {
		Todo todoCreated = todoservice.save(todo);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
			buildAndExpand(todoCreated.getId()).toUri();
		
		return ResponseEntity.created(uri).build();

	}

}
