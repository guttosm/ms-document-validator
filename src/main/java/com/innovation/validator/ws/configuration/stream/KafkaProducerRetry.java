package com.innovation.validator.ws.configuration.stream;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducerRetry {

    @Value("${validator.request.kafka.topic.retry}")
    private String topic;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg, Integer count, String origin) {
        Message<String> messageRetry = MessageBuilder
                .withPayload(msg)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .setHeader("COUNT", count + 1)
                .setHeader("ORIGIN", origin)
                .build();
        kafkaTemplate.send(messageRetry);
    }

}