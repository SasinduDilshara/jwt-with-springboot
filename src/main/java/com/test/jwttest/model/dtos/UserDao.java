package com.test.jwttest.model.dtos;

import java.util.Optional;

public interface UserDao {

    public Optional<User> selectUserByUsername(String username);
}
