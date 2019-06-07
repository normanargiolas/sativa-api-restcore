package com.sativachain.api.service;

import java.util.Optional;

import com.sativachain.api.model.entity.User;

public interface IUserService {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    void save(User user);
}
