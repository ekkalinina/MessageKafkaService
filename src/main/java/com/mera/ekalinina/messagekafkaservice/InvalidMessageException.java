package com.mera.ekalinina.messagekafkaservice;

public class InvalidMessageException extends Exception {

    public InvalidMessageException(String message) {
        super(message);
    }
}
