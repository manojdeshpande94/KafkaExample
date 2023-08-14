package com.example.kafkaexample.service;

import com.example.kafkaexample.exception.MessageNotSentException;
import com.example.kafkaexample.record.TopicMessagePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(TopicMessagePair topicMessagePair) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicMessagePair.topic(), topicMessagePair.message());
        future.whenComplete((result, throwable) -> {
            if (throwable != null)
                throw new MessageNotSentException("Unable to send message: " + topicMessagePair.message(), throwable);
            System.out.printf("Message on topic: %s, is sent: %s", topicMessagePair.topic(), topicMessagePair.message());
        });
    }

}
