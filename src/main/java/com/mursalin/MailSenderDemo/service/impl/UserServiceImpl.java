package com.mursalin.MailSenderDemo.service.impl;

import com.mursalin.MailSenderDemo.model.User;
import com.mursalin.MailSenderDemo.repository.UserRepository;
import com.mursalin.MailSenderDemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Override
    public User register(User user) {

        if(userRepository.existByEmailIgnoreCase(user.getEmail())) {
            return userRepository.save(user);
        }
        return null;
    }
}
