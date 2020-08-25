package com.springbootMongo.CRUD.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springbootMongo.CRUD.api.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer> {

}
