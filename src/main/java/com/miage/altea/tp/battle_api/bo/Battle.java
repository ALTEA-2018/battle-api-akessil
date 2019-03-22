package com.miage.altea.tp.battle_api.bo;

public class Battle {
    private String uuid;
    BattleTrainer trainer;
    BattleTrainer opponent;

    public Battle(final String uuid){
        this.uuid = uuid;
    }

    public String getUuid(){
        return this.uuid;
    }

    public BattleTrainer getTrainer() {
        return trainer;
    }

    public void setTrainer(BattleTrainer trainer) {
        this.trainer = trainer;
    }

    public BattleTrainer getOpponent() {
        return opponent;
    }

    public void setOpponent(BattleTrainer opponent) {
        this.opponent = opponent;
    }
}
