package com.sativachain.api.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sativachain.api.model.entity.Todo;

@Repository
public interface ITodoDAO extends JpaRepository<Todo, Long> {
    List<Todo> findByUsername(String username);
}
