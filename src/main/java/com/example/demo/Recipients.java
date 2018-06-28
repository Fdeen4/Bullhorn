package com.example.demo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Recipients {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String myName;

    @ManyToMany(mappedBy = "recipients")
    private Set<Message> messages;

    public Recipients() {
        messages = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }
}