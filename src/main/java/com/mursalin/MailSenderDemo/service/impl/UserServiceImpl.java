package com.mursalin.MailSenderDemo.service.impl;

import com.mursalin.MailSenderDemo.model.Confirmation;
import com.mursalin.MailSenderDemo.model.User;
import com.mursalin.MailSenderDemo.repository.ConfirmationRepository;
import com.mursalin.MailSenderDemo.repository.UserRepository;
import com.mursalin.MailSenderDemo.service.MailService;
import com.mursalin.MailSenderDemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ConfirmationRepository confirmationRepository;
    private MailService mailService;

    public UserServiceImpl(UserRepository userRepository, ConfirmationRepository confirmationRepository, MailService mailService) {
        this.userRepository = userRepository;
        this.confirmationRepository = confirmationRepository;
        this.mailService = mailService;
    }

    @Override
    public User register(User user) {

        if(!userRepository.existsByEmailIgnoreCase(user.getEmail())) {
            user.setEnable(false);
            Confirmation confirmation = new Confirmation(user);
            userRepository.save(user);
            confirmationRepository.save(confirmation);
            mailService.sendSimpleMail(user.getName(), user.getEmail(),confirmation.getToken());
            return user;
        }
        throw new RuntimeException("user exist by this email");
    }

    @Override
    public ResponseEntity<?> verifyToken(String token) {
        Confirmation confirmation = confirmationRepository.findByToken(token);
        User user = confirmation.getUser();
        user.setEnable(true);
        userRepository.save(user);
        return new ResponseEntity<>("user verified", HttpStatus.OK);
    }
}
