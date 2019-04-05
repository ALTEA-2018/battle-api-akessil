package com.miage.altea.tp.battle_api.bo;

import java.util.ArrayList;
import java.util.List;

public class BattleTrainer {

    private String name;

    private List<BattlePokemon> team;

    private Boolean nextTurn;

    public BattleTrainer(String name){
        this.name = name;
        team = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<BattlePokemon> getTeam() {
        return team;
    }

    public void setTeam(List<BattlePokemon> team) {
        this.team = team;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getNextTurn() {
        return nextTurn;
    }

    public void setNextTurn(Boolean nextTurn) {
        this.nextTurn = nextTurn;
    }
}
