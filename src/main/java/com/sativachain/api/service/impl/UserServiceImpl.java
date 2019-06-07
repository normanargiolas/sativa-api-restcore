package com.sativachain.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sativachain.api.model.dao.IUserDAO;
import com.sativachain.api.model.entity.User;
import com.sativachain.api.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDAO userDAO;

    @Override
    public Optional<User> findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userDAO.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userDAO.existsByEmail(email);
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }
}
