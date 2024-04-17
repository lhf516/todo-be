package com.fungtech.todolist.Dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fungtech.todolist.Model.Todo;

public interface TodoRepository extends MongoRepository<Todo, String> {

}
