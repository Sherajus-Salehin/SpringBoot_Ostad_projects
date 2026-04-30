package com.example.Assignment15.service;

import com.example.Assignment15.model.User;
import com.example.Assignment15.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
//    @Autowired
//    private final UserRepository userRepository;
//    @Autowired
//    private final PasswordEncoder passwordEncoder;
//
//    public User createUser(User user) {
//        user.setRole("ROLE_USER");
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        return userRepository.save(user);
//    }
//
//    public User createAdmin(User user) {
//        user.setRole("ROLE_ADMIN");
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        return userRepository.save(user);
//    }
}
