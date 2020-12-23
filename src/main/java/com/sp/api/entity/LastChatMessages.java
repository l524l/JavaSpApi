package com.sp.api.entity;

import java.util.Arrays;
import java.util.List;

/**
 * @Author Pershin Andrew
 */
public class LastChatMessages {

    private Message[] messages;

    public LastChatMessages() {
    }

    public LastChatMessages(List<Message> messages) {
        this.messages = (Message[]) messages.toArray();
    }
    public LastChatMessages(Message[] messages) {
        this.messages = messages;
    }


    public List<Message> getMessagesAsList() {
        return Arrays.asList(messages);
    }

    public void setMessagesFromList(List<Message> messages) {
        this.messages = (Message[]) messages.toArray();
    }

    public Message[] getMessages() {
        return messages;
    }

    public void setMessages(Message[] messages) {
        this.messages = messages.clone();
    }

}
