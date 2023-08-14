package com.example.kafkaexample.service;

import com.example.kafkaexample.kafka.producer.Producer;
import com.example.kafkaexample.record.TopicMessagePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    private Producer producer;

    public void sendMessage(TopicMessagePair topicMessagePair) {
        producer.sendMessage(topicMessagePair.topic(), topicMessagePair.message());
    }

}
