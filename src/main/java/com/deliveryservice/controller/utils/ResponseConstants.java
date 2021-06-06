package com.deliveryservice.controller.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseConstants {
    public static final ResponseEntity<Void> CREATED = ResponseEntity.status(HttpStatus.CREATED).build();
    public static final ResponseEntity<String> ALREADY_EMAIL =  ResponseEntity.status(HttpStatus.CONFLICT).body("이미 존재하는 이메일 입니다.");
}
