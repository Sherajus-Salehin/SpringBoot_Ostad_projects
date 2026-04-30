package com.example.Assignment15.service;

import com.example.Assignment15.model.User;
import com.example.Assignment15.repository.UserRepository;
import com.example.Assignment15.utilities.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public String registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        userRepository.save(user);
        return "User registered successfully";
    }
    public String registerAdmin(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_ADMIN");
        userRepository.save(user);
        return "Admin registered successfully";
    }
    public String login(String username, String password) {
        User user=userRepository.findByUsername(username).orElseThrow(()->new RuntimeException("Username not found"));

        if(!passwordEncoder.matches(password,user.getPassword())){
            throw new RuntimeException("Wrong password");
        }
    return   jwtUtil.generateToken(user);
    }
}
