package com.miage.altea.tp.battle_api.service.factory;


import com.miage.altea.tp.battle_api.bo.BattlePokemon;

public class BattlePokemonFactory {
    private static  BattlePokemonFactory INSTANCE = new BattlePokemonFactory();
    private BattlePokemonFactory(){}

    public static BattlePokemonFactory getInstance(){
        return INSTANCE;
    }
    public BattlePokemon createBattlePokemon(){
        BattlePokemon pokemon = new BattlePokemon();

        return pokemon;
    }
}
