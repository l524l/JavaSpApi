package com.sp.api.entity;

/**
 * @Author Pershin Andrew
 */
public class Message {
    private String name;
    private String message;
    private long time;

    public Message() {
    }

    public Message(String name, String text, long time) {
        this.name = name;
        this.message = text;
        this.time = time;
    }

    public String getSenderName() {
        return name;
    }

    public void setSenderName(String sender) {
        this.name = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
        if (!name.equals(message.name)) return false;
        return this.message.equals(message.message);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + message.hashCode();
        result = 31 * result + (int) (time ^ (time >>> 32));
        return result;
    }
}
