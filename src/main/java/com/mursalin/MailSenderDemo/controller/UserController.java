package com.mursalin.MailSenderDemo.controller;

import com.mursalin.MailSenderDemo.model.User;
import com.mursalin.MailSenderDemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
//@RequiredArgsConstructor
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public User userRegistration(@RequestBody User user) {
        return userService.register(user);
    }

    @GetMapping
    public ResponseEntity<?> verifyToken(@RequestParam String token) {

        return userService.verifyToken(token);
    }
}
