package com.example.kafkaexample.exception;

public class MessageNotSentException extends RuntimeException {

    public MessageNotSentException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
