package com.miage.altea.tp.battle_api.bo;

import com.miage.altea.tp.battle_api.pokemon_type.bo.PokemonType;

public class BattlePokemon {
    private int id;
    private PokemonType type;
    private int maxHp;
    private int attack;
    private int defense;
    private int speed;
    private int level;
    private int hp;
    private Boolean ko;
    private Boolean alive;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PokemonType getType() {
        return type;
    }

    public void setType(PokemonType type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Boolean getKo() {
        return ko;
    }

    public void setKo(Boolean ko) {
        this.ko = ko;
    }

    public Boolean getAlive() {
        return alive;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }
}
