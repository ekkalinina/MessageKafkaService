package com.mera.ekalinina.messagekafkaservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MessageController {

    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    MessageKafkaProducer messageProducer;

    @PostMapping("/send_message")
    public void sendMessage(
            @RequestParam(value = "from") String from,
            @RequestParam(value = "to") String to,
            @RequestBody String text) throws InvalidMessageException {
        if(from.isEmpty())
            throw new InvalidMessageException("<From> message field is empty");
        if(to.isEmpty())
            throw new InvalidMessageException("<To> message field is empty");
        messageProducer.sendMessage(new Message(counter.incrementAndGet(), from, to, text));
    }
}

