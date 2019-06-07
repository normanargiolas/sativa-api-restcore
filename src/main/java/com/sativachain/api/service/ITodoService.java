package com.sativachain.api.service;

import java.util.List;

import com.sativachain.api.model.entity.Todo;

public interface ITodoService {
    List<Todo> findByUsername(String username);
}
