package com.mursalin.MailSenderDemo.service.impl;

import com.mursalin.MailSenderDemo.model.Confirmation;
import com.mursalin.MailSenderDemo.model.User;
import com.mursalin.MailSenderDemo.repository.ConfirmationRepository;
import com.mursalin.MailSenderDemo.repository.UserRepository;
import com.mursalin.MailSenderDemo.service.MailService;
import com.mursalin.MailSenderDemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ConfirmationRepository confirmationRepository;
    private MailService mailService;

    @Override
    public User register(User user) {

        if(!userRepository.existByEmailIgnoreCase(user.getEmail())) {
            Confirmation confirmation = new Confirmation(user);
            confirmationRepository.save(confirmation);
            mailService.sendSimpleMail(user.getName(), user.getEmail(),confirmation.getToken());
            return userRepository.save(user);
        }
        throw new RuntimeException("user exist by this email");
        return null;
    }
}
