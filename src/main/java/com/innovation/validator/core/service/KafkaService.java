package com.innovation.validator.core.service;

import com.innovation.validator.ws.configuration.MessageDTO;

public interface KafkaService {

    void sendMessage(final String kafkaTopicName, final String eventName, final MessageDTO messageIsGonaBeSendToKafka);

}