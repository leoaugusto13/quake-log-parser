package com.leonardo.logparser.model;


public class Player {
    private String id;

    private String name;

    private PlayerKD playerKD;

    @Override
    public String toString() {
        return "name: " + this.name + ", playerKD: " + this.playerKD;
    }

    public Player(final String id, final String name, final PlayerKD playerKD) {
        this.id = id;
        this.name = name;
        this.playerKD = playerKD;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public PlayerKD getPlayerKD() {
        return playerKD;
    }

    public void setPlayerKD(PlayerKD playerKD) {
        this.playerKD = playerKD;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

}
