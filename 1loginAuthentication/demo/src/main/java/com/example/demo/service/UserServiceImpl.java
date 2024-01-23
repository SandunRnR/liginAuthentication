package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean authenticateUser(String username, String password) {
        User user = userRepository.findByUsername(username);

        // Add your authentication logic here (e.g., comparing passwords)

        return user != null && user.getPassword().equals(password);
    }
}
