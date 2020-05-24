package com.leonardo.logparser.model;

import java.util.List;

public class Game {
    private final String name;

    private final List<Player> players;

    public Game(final String name, final List<Player> players) {
        this.name = name;
        this.players = players;
    }

       public String getName() {
        return this.name;
    }

    public List<Player> getPlayers() {
        return this.players;
    }



}
