package com.example.kafkaexample.kafka.producer;

import com.example.kafkaexample.exception.MessageNotSentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class Producer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String topic, String message) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, message);
        future.whenComplete((result, throwable) -> {
            if (throwable != null)
                throw new MessageNotSentException("Unable to send message: " + message, throwable);
            System.out.printf("Message on topic: %s, is sent: %s\n", topic, message);
        });
    }

}
