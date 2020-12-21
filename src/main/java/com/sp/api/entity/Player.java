package com.sp.api.entity;

import java.util.UUID;

/**
 * @Author Pershin Andrew
 */
public class Player {
    private String nickname;
    private UUID uuid;

    public Player() {
    }

    public Player(String nickname, UUID uuid) {
        this.nickname = nickname;
        this.uuid = uuid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (!nickname.equals(player.nickname)) return false;
        return uuid.equals(player.uuid);
    }

    @Override
    public int hashCode() {
        int result = nickname.hashCode();
        result = 31 * result + uuid.hashCode();
        return result;
    }
}
