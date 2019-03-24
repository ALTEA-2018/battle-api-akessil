package com.miage.altea.tp.battle_api.service.util;

public class AttackCalculator {

    private static AttackCalculator INSTANCE = new AttackCalculator();
    private AttackCalculator(){}

    public static AttackCalculator getInstance(){
        return INSTANCE;
    }

    /**
     *
     * @param level: trainer pokemon level
     * @param attack: trainer pokemon attack
     * @param defense: opponent pokemon defense
     * @return
     */
    public int calculateDamages(int level, int attack, int defense){
        int damage = (int)( (2 * (float)level/5) + (2 * (((float)attack/defense))) )+2;
        return damage;
    }
}
