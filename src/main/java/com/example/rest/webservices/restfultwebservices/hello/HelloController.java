package com.example.rest.webservices.restfultwebservices.hello;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/helo")
	public String sayHelo() {
		return "Hii.... this is my first REST api";
	}
	
	@GetMapping("/helo-bean")
	public HelloBean heloBean() {
		return new HelloBean("Hello World");
	}
	
	@GetMapping("/helo/path-variable/{name}")
	public HelloBean heloPathVariable(@PathVariable String name) {
		return new HelloBean(String.format("Hello World, %s" ,name));
	}

}
