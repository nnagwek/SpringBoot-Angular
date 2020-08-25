package com.springAngular.rest.webservices.springAngularrestwebservices.helloworld;

public class HelloWorldBean  {
	
	private String message;
	private String name;
	
	public HelloWorldBean(String message) {
		super();
		this.message = message;
		
	}
	
	public HelloWorldBean(String message, String name) {
		super();
		this.message = message;
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return String.format("HelloWorldBean [message=%s, name=%s]", message, name);
	}

	
	
	
}
