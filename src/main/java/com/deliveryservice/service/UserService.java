package com.deliveryservice.service;

import com.deliveryservice.controller.dto.UserDto;
import com.deliveryservice.domain.user.repository.UserRepository;
import com.deliveryservice.exception.user.EmailDuplicateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveUser(UserDto userDto) {
        emailDuplicateCheck(userDto.getEmail());
        String encodePassword = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(encodePassword);
        userRepository.save(userDto.toUserEntity());
    }

    public void saveUser2(UserDto userDto) {
        emailDuplicateCheck(userDto.getEmail());
        String encodePassword = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(encodePassword);
        userRepository.save(userDto.toUserEntity());
    }

    public void emailDuplicateCheck(String email) {
        if (userRepository.existsByEmail(email)) {
            throw new EmailDuplicateException();
        }
    }
}