package com.mera.ekalinina.messagekafkaservice;

public class Message {

    private long id;
    private String from;
    private String to;
    private String text;

    public Message() {
        this(0, "", "", "");
    }

    public Message(long id, String from, String to, String text) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
