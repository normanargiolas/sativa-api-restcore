package com.sativachain.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sativachain.api.model.entity.Todo;
import com.sativachain.api.model.dao.ITodoDAO;
import com.sativachain.api.service.ITodoService;

@Service
public class TodoServiceImpl implements ITodoService {

    @Autowired
    private ITodoDAO todo;

    @Override
    public List<Todo> findByUsername(String username) {
        return todo.findByUsername(username);
    }
}
