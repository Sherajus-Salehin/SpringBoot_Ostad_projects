package com.example.Assignment15.service;

import com.example.Assignment15.model.User;
import com.example.Assignment15.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public User createUser(User user) {
        user.setRole("ROLE_USER");
        return userRepository.save(user);
    }
    public User createAdmin(User user) {
        user.setRole("ROLE_ADMIN");
        return userRepository.save(user);
    }
}
