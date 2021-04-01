package com.deliveryservice.controller;

import static com.deliveryservice.controller.utils.ResponseConstants.CREATED;
import com.deliveryservice.controller.dto.UserDto;
import com.deliveryservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<Void> createUser(@Valid @RequestBody UserDto userDto) {
        userService.saveUser(userDto);
        return CREATED;
    }

}