package com.sbms.mongo.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sbms.mongo.api.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer> {

}
