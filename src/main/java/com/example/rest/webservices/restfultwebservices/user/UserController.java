package com.example.rest.webservices.restfultwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import java.net.URI;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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

	//http://localhost:8082/users
	//SpringBoot hateoas
	//EntityModel: to wrap the model 
	//WenMvcLinkBuilder: to add the links to the model
	@GetMapping("/users/{id}")
	public EntityModel<User> findUserById(@PathVariable Integer id) {
		User user= service.findOne(id);
		if(user==null) {
			throw new UserNotFoundException("id:"+id);
		}
		EntityModel<User> entityModel =  EntityModel.of(user);
		
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUser());
		entityModel.add(link.withRel("all-users"));
		return entityModel;

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
