package com.sp.api.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

/**
 * Author Pershin Andrew
 */
public class Message {
    private String name;
    private String message;
    private long time;
    private UUID uuid;

    public Message(Player player, String text, long time) {
        this.name = player.getNickname();
        this.uuid = player.getUuid();
        this.message = text;
        this.time = time;
    }

    public Message(Player player, String text, LocalDateTime localDateTime) {
        this.name = player.getNickname();
        this.uuid = player.getUuid();
        this.message = text;
        this.time = localDateTime.toLocalDate().toEpochDay();
    }

    public Player getSender(){
        return new Player(name, uuid);
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTime() {
        return LocalDateTime.of(LocalDate.ofEpochDay(time),LocalTime.ofSecondOfDay(time));
    }

    public long getTimeAsLong() {
        return time;
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
