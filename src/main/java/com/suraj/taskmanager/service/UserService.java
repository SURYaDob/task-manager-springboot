package com.suraj.taskmanager.service;

import com.suraj.taskmanager.model.User;
import com.suraj.taskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(String fullName, String email, String password) {
        // Check if email already exists
        User existingUser = userRepository.findByEmail(email);
        if (existingUser != null) {
            return null; // Email already taken
        }

        User user = new User();
        user.setFullName(fullName);
        user.setEmail(email);
        user.setPassword(password);
        return userRepository.save(user);
    }

    public User loginUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null; // Invalid credentials
    }
}