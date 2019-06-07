package com.sativachain.api.model.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sativachain.api.model.entity.Role;
import com.sativachain.api.model.entity.RoleName;

@Repository
public interface IRoleDAO extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
