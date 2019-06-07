package com.sativachain.api.service;

import java.util.Optional;

import com.sativachain.api.model.entity.Role;
import com.sativachain.api.model.entity.RoleName;

public interface IRoleService {
    Optional<Role> findByName(RoleName roleName);
}
