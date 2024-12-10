package com.mursalin.MailSenderDemo.controller;

import com.mursalin.MailSenderDemo.model.User;
import com.mursalin.MailSenderDemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<?> userRegistration(@RequestBody User user) {
        userService.register(user);
    }


}
