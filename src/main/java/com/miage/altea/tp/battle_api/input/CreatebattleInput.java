package com.miage.altea.tp.battle_api.input;

public class CreatebattleInput {
    private String trainer;
    private String opponent;

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }
}
