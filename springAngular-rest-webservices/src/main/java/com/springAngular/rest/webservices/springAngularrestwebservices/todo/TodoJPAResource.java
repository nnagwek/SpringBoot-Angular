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
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoJPAResource {

	@Autowired
	private TodoHardcodedService todoservice;

	@Autowired
	private TodoJPARepository todoJPARepository;
	
	@GetMapping("/api/jpa/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username) {
		return todoJPARepository.findByUsername(username);
//		return todoservice.findAll();
	}

	@GetMapping("/api/jpa/users/{username}/todos/{id}")
	public Todo getTodo(@PathVariable String username, @PathVariable long id) {
		return todoJPARepository.findById(id).get();
//		return todoservice.findById(id);
	}

	@DeleteMapping("/api/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {
		
		todoJPARepository.deleteById(id);
//		Todo todoDeleteById = todoservice.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/api/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id,
			@RequestBody Todo todo) {
//		Todo todoUpdated = todoservice.save(todo);
		todo.setUsername(username);
		Todo todoUpdated = todoJPARepository.save(todo);
		return new ResponseEntity<Todo>(todoUpdated, HttpStatus.OK);

	}
	
	@PostMapping("/api/jpa/users/{username}/todos")
	public ResponseEntity<Void> createTodo(@PathVariable String username,
			@RequestBody Todo todo) {
//		Todo todoCreated = todoservice.save(todo);
		todo.setUsername(username);
		Todo todoCreated = todoJPARepository.save(todo);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
			buildAndExpand(todoCreated.getId()).toUri();
		
		return ResponseEntity.created(uri).build(); 
	}

}
