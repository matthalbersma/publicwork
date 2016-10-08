package com.mongorest.Models;

import org.springframework.data.annotation.Id;

/**
 * Created by walter on 10/7/16.
 */
public class Message {
    @Id
    private String id;
    private String body;
    private MessageUser to;
    private MessageUser from;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MessageUser getTo() {
        return to;
    }

    public void setTo(MessageUser to) {
        this.to = to;
    }

    public MessageUser getFrom() {
        return from;
    }

    public void setFrom(MessageUser from) {
        this.from = from;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Message{" +
                "body='" + body + '\'' +
                ", to=" + to +
                ", from=" + from +
                '}';
    }
}
