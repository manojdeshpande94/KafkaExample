package com.example.kafkaexample.controller;

import com.example.kafkaexample.exception.MessageNotSentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceConfig {

    @ExceptionHandler(MessageNotSentException.class)
    public ResponseEntity<String> handleMessageNotSentException(MessageNotSentException messageNotSentException) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageNotSentException.getMessage());
    }

}
