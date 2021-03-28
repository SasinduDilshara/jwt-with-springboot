package com.test.jwttest.service;

import com.test.jwttest.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public User findByUsernameAndPassword(String username , String password);
    public User findByUsername(String username);
    public void saveOrUpdateUser(User user);
}
