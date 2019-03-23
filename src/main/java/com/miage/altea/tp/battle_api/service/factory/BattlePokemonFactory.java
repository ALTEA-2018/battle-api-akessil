package com.miage.altea.tp.battle_api.service.factory;


import com.miage.altea.tp.battle_api.bo.Battle;
import com.miage.altea.tp.battle_api.bo.BattlePokemon;
import com.miage.altea.tp.battle_api.pokemon_info.bo.PokemonInfo;

import java.util.ArrayList;
import java.util.List;

public class BattlePokemonFactory {
    private static StatCalculator calculator;
    private static  BattlePokemonFactory INSTANCE = new BattlePokemonFactory();
    private BattlePokemonFactory(){
        calculator = StatCalculator.getInstance();
    }

    public static BattlePokemonFactory getInstance(){
        return INSTANCE;
    }

    public BattlePokemon createBattlePokemon(PokemonInfo pokemonInfo){
        int level = pokemonInfo.getLevel();
        int baseAttack = pokemonInfo.getPokemonType().getStats().getAttack();
        int baseDefense = pokemonInfo.getPokemonType().getStats().getDefense();
        int baseSpeed = pokemonInfo.getPokemonType().getStats().getSpeed();
        int baseHp = pokemonInfo.getPokemonType().getStats().getHp();

        BattlePokemon battlePokemon = new BattlePokemon();
        battlePokemon.setId(pokemonInfo.getId());
        battlePokemon.setLevel(level);
        battlePokemon.setPokemonType(pokemonInfo.getPokemonType().getId());

        //toFix
        battlePokemon.setMaxHp(36);
        battlePokemon.setAttack(calculator.calculateAttack(level, baseAttack));
        battlePokemon.setDefense(calculator.calculateDefense(level,baseDefense));
        battlePokemon.setSpeed(calculator.calculateSpeed(level,baseSpeed));
        battlePokemon.setHp(calculator.calculateHP(level,baseHp));

        return battlePokemon;
    }

    public List<BattlePokemon> getBattlePokemons(List<PokemonInfo> pokemons){
        final List<BattlePokemon> battlePokemons = new ArrayList<>();

        for(PokemonInfo pokemonInfo : pokemons) {
            BattlePokemon battlePokemon = this.createBattlePokemon(pokemonInfo);
            battlePokemons.add(battlePokemon);
        }

        return battlePokemons;
    }
}
