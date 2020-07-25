package com.mera.ekalinina.messagekafkaservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class MessageKafkaProducer {

    private static final String TOPIC = "message_test";
    private static final Logger logger = LoggerFactory.getLogger(MessageKafkaProducer.class);

    @Autowired
    @Qualifier("messageKafkaTemplate")
    private KafkaTemplate<String, Message> messageKafkaTemplate;

    public void sendMessage(Message msg) {

        logger.info("Trying to send message of topic=" + "<" + TOPIC + "> to Kafka Server : " + msg);
        ListenableFuture<SendResult<String, Message>> future =
                messageKafkaTemplate.send(TOPIC, msg);

        future.addCallback(new ListenableFutureCallback<SendResult<String, Message>>() {

            @Override
            public void onSuccess(SendResult<String, Message> result) {
                logger.info("Message = " + msg +" was sent");
            }
            @Override
            public void onFailure(Throwable ex) {
                logger.error("Unable to send message = "
                        + msg + " due to : " + ex.getMessage());
            }
        });
    }
}
