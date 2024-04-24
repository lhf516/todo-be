package com.fungtech.todolist.Dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fungtech.todolist.Model.Task;

public interface TaskRepository extends MongoRepository<Task, UUID> {
  List<Task> findByDeletedAtNull();
}
