package com.example.demo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String messageName;

    @ManyToMany()
    private Set<Recipients> recipients;

    public Message() {
        recipients = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessageName() {
        return messageName;
    }

    public void setMessageName(String messageName) {
        this.messageName = messageName;
    }

    public Set<Recipients> getRecipients() {
        return recipients;
    }

    public void setRecipients(Set<Recipients> recipients) {
        this.recipients = recipients;
    }
}