package com.sativachain.api.service;

import java.util.List;
import java.util.Optional;

import com.sativachain.api.model.entity.Todo;

public interface ITodoService {
    List<Todo> findByUsername(String username);
    Optional<Todo> findById(long username);
    void deleteById(long id);
    Todo save(Todo todo);
}
