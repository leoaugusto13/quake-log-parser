package com.leonardo.logparser.model;

import java.util.HashMap;
import java.util.Map;

public class PlayerKD {

    private Integer validKills;

    private Integer countKill;

    private Integer countDeath;

    private final Map<DeathType, Integer> countDeathType;

    public PlayerKD() {
        this.countKill = 0;
        this.countDeath = 0;
        this.setValidKills(0);
        this.countDeathType = new HashMap<>();
    }

    public Integer getCountDeath() {
        return countDeath;
    }

    public void setCountDeath(Integer countDeath) {
        this.countDeath = countDeath;
    }

    public Integer getCountKill() {
        return countKill;
    }

    public void setCountKill(Integer countKill) {
        this.countKill = countKill;
    }

    public void addValidKill() {
        this.validKills++;
    }

    public void addKill() {
        this.countKill++;
    }

    public void addDeath() {
        this.countDeath++;
    }

    public void punish() {
        this.countKill--;
    }


    public Map<DeathType, Integer> getCountDeathType() {
        return countDeathType;
    }


    public void addDeathType(final DeathType deathType) {
        if (!this.countDeathType.containsKey(deathType)) {
            this.countDeathType.put(deathType, 0);
        }

        final Integer previousValue = this.countDeathType.get(deathType);
        this.countDeathType.put(deathType, previousValue + 1);
    }


    public Integer getValidKills() {
        return validKills;
    }


    public void setValidKills(Integer validKills) {
        this.validKills = validKills;
    }

}



