package com.deliveryservice.service;

import com.deliveryservice.controller.dto.UserDto;
import com.deliveryservice.domain.user.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    @DisplayName("회원가입 성공")
    void createUser() {
        UserDto userDto = UserDto.builder()
                .email("guddlf13@naver.com")
                .password("a123123123a")
                .name("형일")
                .phone("010-8865-8860")
                .address("서울")
                .build();

        when(userRepository.existsByEmail("guddlf13@naver.com")).thenReturn(true);

        userService.saveUser(userDto);

        verify(userRepository, atLeastOnce()).save(any());

    }


}