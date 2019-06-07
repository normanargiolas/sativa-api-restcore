package com.sativachain.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sativachain.api.model.entity.Todo;
import com.sativachain.api.model.dao.ITodoDAO;
import com.sativachain.api.service.ITodoService;

@Service
public class TodoServiceImpl implements ITodoService {

    @Autowired
    private ITodoDAO todoDAO;

    @Override
    public List<Todo> findByUsername(String username) {
        return todoDAO.findByUsername(username);
    }

    @Override
    public Optional<Todo> findById(long id) {
        return todoDAO.findById(id);
    }

    @Override
    public void deleteById(long id) {
        todoDAO.deleteById(id);
    }

    @Override
    public Todo save(Todo todo) {
        return todoDAO.save(todo);
    }
}
