package com.example.kafkaexample.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static com.example.kafkaexample.util.Constants.CONSUMER_GROUP_ID;
import static com.example.kafkaexample.util.Constants.KAFKA_TOPIC;

@Component
public class Consumer {

    @KafkaListener(topics = KAFKA_TOPIC, groupId = CONSUMER_GROUP_ID)
    public void listen(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION) int partitionId) {
        System.out.printf("PartitionId: %s\nReceived message: %s\n", partitionId, message);
    }

}
