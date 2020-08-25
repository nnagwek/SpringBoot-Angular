package com.springbootMongo.CRUD.api.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Document(collection = "Book")
public class Book {

	private int id;
	private String bookName;
	private String authorName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public Book(int id, String bookName, String authorName) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.authorName = authorName;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return String.format("Book [id=%s, bookName=%s, authorName=%s]", id, bookName, authorName);
	}
	
	
}
