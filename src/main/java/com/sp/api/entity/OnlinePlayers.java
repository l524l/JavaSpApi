package com.sp.api.entity;

import com.sp.api.exception.PlayerNotFoundException;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author Pershin Andrew
 */
public class OnlinePlayers {

    private Player[] players;
    private int count;
    private int max;

    public OnlinePlayers(List<Player> players, int max) {
        this.players = (Player[]) players.toArray();
        this.count = players.size();
        this.max = max;
    }

    public OnlinePlayers(Player[] players, int max) {
        this.players = players;
        this.count = players.length;
        this.max = max;
    }

    public Player findByUUID(UUID uuid) throws PlayerNotFoundException {
        AtomicReference<Player> player = new AtomicReference<>(null);
        getPlayersAsList().listIterator().forEachRemaining((x) -> {
            if (x.getUuid().equals(uuid)) player.set(x);
        });
        if (player.get() == null) throw new PlayerNotFoundException();
        return player.get();
    }

    public Player findByName(String name) throws PlayerNotFoundException {
        AtomicReference<Player> player = new AtomicReference<>(null);
        getPlayersAsList().listIterator().forEachRemaining((x) -> {
            if (x.getNickname().equals(name)) player.set(x);
        });
        if (player.get() == null) throw new PlayerNotFoundException();
        return player.get();
    }

    public boolean checkStatusByName(String name){
        AtomicBoolean status = new AtomicBoolean(false);
        getPlayersAsList().listIterator().forEachRemaining((x) -> {
            if (x.getNickname().equals(name)) status.set(true);
        });
        return status.get();
    }

    public boolean checkStatusByUUID(UUID name){
        AtomicBoolean status = new AtomicBoolean(false);
        getPlayersAsList().listIterator().forEachRemaining((x) -> {
            if (x.getUuid().equals(name)) status.set(true);
        });
        return status.get();
    }

    public Player[] getPlayers() {
        return players;
    }

    public List<Player> getPlayersAsList() {
        return Arrays.asList(players);
    }

    public int getCount() {
        return count;
    }

    public int getMax() {
        return max;
    }
}
