package com.mera.ekalinina.messagekafkaservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageKafkaConsumer {

    private static final String TOPIC = "message_test";
    private static final Logger logger = LoggerFactory.getLogger(MessageKafkaConsumer.class);

    @KafkaListener(topics = TOPIC, containerFactory = "messageKafkaListenerContainerFactory")
    public void consume(Message msg) {
        logger.info("Received message of topic=" + "<" + TOPIC + "> from Kafka Server: " + msg);
    }
}
