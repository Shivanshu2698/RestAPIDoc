package com.example.rest.webservices.restfultwebservices.user;

import java.net.URI;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserController {

	private UserDaoService service;

	public UserController(UserDaoService service) {
		super();
		this.service = service;
	}

	@GetMapping("/users")
	public List<User> retrieveAllUser() {
		return service.finadAll();
	}

	@GetMapping("/users/{id}")
	public User findUserById(@PathVariable Integer id) {
		User user= service.findOne(id);
		if(user==null) {
			throw new UserNotFoundException("id:"+id);
		}
		return user;

	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = service.createUser(user);
		URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/delete/{id}")
	public void deleteUserById(@PathVariable Integer id) {
		service.deleteUserById(id);
		
	}
	
	

}
