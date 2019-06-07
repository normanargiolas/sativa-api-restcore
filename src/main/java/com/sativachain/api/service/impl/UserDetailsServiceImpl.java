package com.sativachain.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sativachain.api.dto.jwt.UserPrinciple;
import com.sativachain.api.model.dao.IUserDAO;
import com.sativachain.api.model.entity.User;
import com.sativachain.api.service.IUserDetailsService;

@Service
public class UserDetailsServiceImpl implements IUserDetailsService {

    @Autowired
    IUserDAO IUserDAO;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
    	
        User user = IUserDAO.findByUsername(username)
                	.orElseThrow(() -> 
                        new UsernameNotFoundException("User Not Found with -> username or email : " + username)
        );

        return UserPrinciple.build(user);
    }
}
