package com.test.jwttest.controller;

import com.test.jwttest.model.User;
import com.test.jwttest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/getByUsernameAndPassword/{username}/{password}")
    public User getStudentByStudentNumber(@PathVariable("username") String username, @PathVariable("password") String password) {
        return userService.findByUsernameAndPassword(username , password);
    }

    @GetMapping(value = "/getByUsername/{username}")
    public User getStudentByEmail(@PathVariable("username") String username) {
        return userService.findByUsername(username);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveOrUpdateStudent(@RequestBody User user) {
        userService.saveOrUpdateUser(user);
        return new ResponseEntity("auth user added successfully", HttpStatus.OK);
    }
}
