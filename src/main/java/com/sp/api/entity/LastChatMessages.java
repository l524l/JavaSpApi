package com.sp.api.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @Author Pershin Andrew
 */
public class LastChatMessages {

    private Message[] messages;

    public LastChatMessages(List<Message> messages) {
        this.messages = (Message[]) messages.toArray();
    }

    public LastChatMessages(Message[] messages) {
        this.messages = messages;
    }

    public List<Message> getMessagesAsList() {
        return Arrays.asList(messages);
    }

    public Message[] getMessages() {
        return messages;
    }

    public List<Message> findMessagesBySenderName(String name){
        ArrayList<Message> messages = new ArrayList<>();
        getMessagesAsList().listIterator().forEachRemaining((x) -> {
            if (x.getSender().getNickname().equals(name)) messages.add(x);
        });
        return messages;
    }

    public List<Message> findMessagesBySenderUUID(UUID uuid){
        ArrayList<Message> messages = new ArrayList<>();
        getMessagesAsList().listIterator().forEachRemaining((x) -> {
            if (x.getSender().getUuid().equals(uuid)) messages.add(x);
        });
        return messages;
    }
}
