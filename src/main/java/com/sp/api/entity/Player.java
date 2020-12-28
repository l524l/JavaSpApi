package com.sp.api.entity;

import java.util.UUID;

/**
 * Author Pershin Andrew
 */
public class Player {
    private String nick;
    private UUID uuid;

    public Player(String nickname, UUID uuid) {
        this.nick = nickname;
        this.uuid = uuid;
    }

    public String getNickname() {
        return nick;
    }

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (!nick.equals(player.nick)) return false;
        return uuid.equals(player.uuid);
    }

    @Override
    public int hashCode() {
        int result = nick.hashCode();
        result = 31 * result + uuid.hashCode();
        return result;
    }
}
