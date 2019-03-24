package com.miage.altea.tp.battle_api.service.factory;

public class StatCalculator {
    private static StatCalculator INSTANCE = new StatCalculator();
    private StatCalculator(){}

    public static StatCalculator getInstance(){
        return INSTANCE;
    }

    public int calculateAttack(int level, int baseAttack){
        return calculateStat(level, baseAttack);
    }
    public int calculateSpeed(int level, int baseSpeed){
        return calculateStat(level, baseSpeed);
    }

    public int calculateDefense(int level, int baseDefense){
        return calculateStat(level, baseDefense);
    }

    public int calculateHP(int level, int baseHP){
        int hp = 10 + level + (baseHP*level/50);
        return hp;
    }

    private int calculateStat(int level, int baseStat){
        int stat = 5 + (baseStat * level/50);
        return stat;
    }
}
