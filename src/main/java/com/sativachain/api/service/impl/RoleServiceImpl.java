package com.sativachain.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sativachain.api.model.dao.IRoleDAO;
import com.sativachain.api.model.entity.Role;
import com.sativachain.api.model.entity.RoleName;
import com.sativachain.api.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDAO roleDAO;

    @Override
    public Optional<Role> findByName(RoleName roleName) {
        return roleDAO.findByName(roleName);
    }
}
