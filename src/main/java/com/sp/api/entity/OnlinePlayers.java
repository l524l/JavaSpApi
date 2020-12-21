package com.sp.api.entity;

import java.util.List;

/**
 * @Author Pershin Andrew
 */
public class OnlinePlayers {

    private List<Player> players;
    private int count;
    private int max;

    public OnlinePlayers() {
    }

    public OnlinePlayers(List<Player> players, int max) {
        this.players = players;
        this.count = players.size();
        this.max = max;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
