package com.sp.api.entity;

import java.util.List;

/**
 * @Author Pershin Andrew
 */
public class LastChatMessages {

    public LastChatMessages(List<Message> messages) {
        this.messages = messages;
    }

    public LastChatMessages() {
    }

    private List<Message> messages;

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
