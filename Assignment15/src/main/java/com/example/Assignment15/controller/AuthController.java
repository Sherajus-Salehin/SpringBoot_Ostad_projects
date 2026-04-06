package com.example.Assignment15.controller;

import com.example.Assignment15.model.User;
import com.example.Assignment15.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    UserService userService;
    @PostMapping("/register/user")
    public User registerUser(@RequestBody User user){
        return userService.createUser(user);
    }
    @PostMapping("/register/admin")
    public User registerAdmin(@RequestBody User user){
        return userService.createAdmin(user);
    }
}
