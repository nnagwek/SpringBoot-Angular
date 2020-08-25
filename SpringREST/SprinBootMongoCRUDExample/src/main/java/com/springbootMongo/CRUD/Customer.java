package com.springbootMongo.CRUD;

import org.springframework.data.annotation.Id;

public class Customer {

	@Id
	private String id;
	private String firstname;
	private String lastname;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String id, String firstname, String lastname) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@Override
	public String toString() {
		return String.format("Customer [id=%s, firstname=%s, lastname=%s]", id, firstname, lastname);
	}
	
	
	
}
