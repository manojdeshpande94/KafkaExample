package com.example.kafkaexample.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Value(value = "${kafka.server.address}")
    private String bootstrapServerAddress;

    @Value(value = "${kafka.topic.ballu}")
    private String kafkaGamesTopic;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> kafkaAdminConfig = new HashMap<>();
        kafkaAdminConfig.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServerAddress);
        return new KafkaAdmin(kafkaAdminConfig);
    }

    @Bean
    public NewTopic gamesTopic() {
        return new NewTopic(kafkaGamesTopic, 1, (short) 1);
    }

}
