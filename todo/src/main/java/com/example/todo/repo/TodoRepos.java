package com.example.todo.repo;
import java.util.*;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.todo.entity.Todo;

public interface TodoRepos extends MongoRepository<Todo,Integer> {
public List<Todo> findAllByTask(String Todo);
}
