package com.test.jwttest.service.impl;

import com.test.jwttest.model.User;
import com.test.jwttest.repository.user.UserRepository;
import com.test.jwttest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import static com.test.jwttest.constants.enums.UserRoles.STUDENT;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findByUsernameAndPassword(String email, String password) {
        return userRepository.findByUsernameAndPassword(email, password);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void saveOrUpdateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = findByUsername(s);
        return new com.test.jwttest.model.dtos.User(STUDENT.getGrantedAuthorities(),
                passwordEncoder.encode(user.getPassword()),
                user.getUsername(),
                true,
                true,
                true,
                true);
    }
}
