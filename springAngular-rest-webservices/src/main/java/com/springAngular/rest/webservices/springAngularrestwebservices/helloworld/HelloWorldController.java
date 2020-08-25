package com.springAngular.rest.webservices.springAngularrestwebservices.helloworld;

import javax.management.RuntimeErrorException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class HelloWorldController {

//	@RequestMapping(method = RequestMethod.GET , path = "/hello-world")
	@GetMapping(path = "/api/hello-world")
	public String helloWorld() {
		return "Hello-World" ;
	}
	
	@GetMapping(path = "/api/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
//		throw new RuntimeException("Some Error has occured Contact Customer Support at ***-***-****");
		return new HelloWorldBean("Hello-World from Niket changed one ") ;
	}
		
	@GetMapping(path = "/api/hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloWorldVariable( @PathVariable String name) {
		return new HelloWorldBean("Hello-World from Niket changed one " , name) ;
	}
}
