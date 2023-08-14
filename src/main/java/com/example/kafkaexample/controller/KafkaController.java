package com.example.kafkaexample.controller;

import com.example.kafkaexample.service.KafkaService;
import com.example.kafkaexample.record.TopicMessagePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/kafka")
public class KafkaController {

    @Autowired
    private KafkaService kafkaService;

    @PostMapping("/send")
    public void sendMessage(@RequestBody TopicMessagePair topicMessagePair) {
        kafkaService.sendMessage(topicMessagePair);
    }

}
