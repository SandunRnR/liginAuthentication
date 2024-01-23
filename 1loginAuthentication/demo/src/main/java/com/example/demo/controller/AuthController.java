package com.example.demo.controller;
import com.example.demo.dto.LoginRequestDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDTO loginRequest) {
        if (userService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword())) {
            return "Login successful";
        } else {
            return "Login failed";
        }
    }

}
