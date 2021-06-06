package com.deliveryservice.exception.user.handler;

import com.deliveryservice.exception.user.EmailDuplicateException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import static com.deliveryservice.controller.utils.ResponseConstants.ALREADY_EMAIL;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = EmailDuplicateException.class)
    public ResponseEntity<String> handleEmailDuplicateException() {
        return ALREADY_EMAIL;
    }
}
