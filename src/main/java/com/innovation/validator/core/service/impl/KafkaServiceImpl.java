package com.innovation.validator.core.service.impl;

import com.innovation.validator.core.service.KafkaService;
import com.innovation.validator.core.util.Mensagem;
import com.innovation.validator.ws.configuration.MessageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaServiceImpl implements KafkaService {

    private final Mensagem mensagem;
    private final KafkaTemplate kafkaTemplate;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${spring.application.name}")
    private String applicationName;

    @Override
    public void sendMessage(final String kafkaTopicName, final String eventName, final MessageDTO messageIsGonaBeSendToKafka) {
        if (!ObjectUtils.isEmpty(messageIsGonaBeSendToKafka)){
            Message message = MessageBuilder
                   .withPayload(messageIsGonaBeSendToKafka)
                   .setHeader(KafkaHeaders.TOPIC, kafkaTopicName)
                   .setHeader("contentType", MediaType.APPLICATION_JSON)
                   .setHeader("applicationName",applicationName)
                   .setHeader("eventId", UUID.randomUUID())
                   .setHeader("eventName", eventName)
                   .setHeader("correlationId",UUID.randomUUID())
                   .build();
           kafkaTemplate.send(message);
        }
    }
}