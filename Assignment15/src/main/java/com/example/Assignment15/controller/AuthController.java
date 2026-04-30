package com.example.Assignment15.controller;

import com.example.Assignment15.model.User;
import com.example.Assignment15.service.AuthService;
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
//    @Autowired
//    UserService userService;
    @Autowired
    AuthService authService;
    @PostMapping("/login")
    public String login(@RequestBody User user){
        return authService.login(user.getUsername(), user.getPassword());
    }

    @PostMapping("/register/user")
    public String registerUser(@RequestBody User user){
        return authService.registerUser(user);
    }
    @PostMapping("/register/admin")
    public String registerAdmin(@RequestBody User user){
        return authService.registerAdmin(user);
    }
}
