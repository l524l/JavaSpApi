package com.sp.api.entity;

import com.google.gson.annotations.JsonAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
