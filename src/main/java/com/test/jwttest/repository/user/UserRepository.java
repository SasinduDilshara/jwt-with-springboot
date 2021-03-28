package com.test.jwttest.repository.user;

import com.test.jwttest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsernameAndPassword(String email , String password);
    User findByUsername(String password);
}
