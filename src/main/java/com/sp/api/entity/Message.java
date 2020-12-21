package com.sp.api.entity;

/**
 * @Author Pershin Andrew
 */
public class Message {
    private Player sender;
    private String text;
    private long time;

    public Message() {
    }

    public Message(Player sender, String text, long time) {
        this.sender = sender;
        this.text = text;
        this.time = time;
    }

    public Player getSender() {
        return sender;
    }

    public void setSender(Player sender) {
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (time != message.time) return false;
        if (!sender.equals(message.sender)) return false;
        return text.equals(message.text);
    }

    @Override
    public int hashCode() {
        int result = sender.hashCode();
        result = 31 * result + text.hashCode();
        result = 31 * result + (int) (time ^ (time >>> 32));
        return result;
    }
}
