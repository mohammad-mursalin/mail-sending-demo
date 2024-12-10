package com.mursalin.MailSenderDemo.service;

import com.mursalin.MailSenderDemo.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    User register(User user);

    ResponseEntity<?> verifyToken(String token);
}
