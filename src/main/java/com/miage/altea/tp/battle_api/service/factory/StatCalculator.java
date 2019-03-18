package com.miage.altea.tp.battle_api.service.factory;

public class StatCalculator {
    private static StatCalculator INSTANCE = new StatCalculator();
    private StatCalculator(){}

    public static StatCalculator getInstance(){
        return INSTANCE;
    }

    public int calculateAttack(int level, int baseAttack){
        int attack = 5 + (baseAttack * level/50);
        return attack;
    }
}
