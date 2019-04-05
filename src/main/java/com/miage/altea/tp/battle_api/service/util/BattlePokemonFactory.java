package com.miage.altea.tp.battle_api.service.util;


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
        battlePokemon.setType(pokemonInfo.getPokemonType());

        battlePokemon.setMaxHp(calculator.calculateHP(level,baseHp));
        battlePokemon.setAttack(calculator.calculateAttack(level, baseAttack));
        battlePokemon.setDefense(calculator.calculateDefense(level,baseDefense));
        battlePokemon.setSpeed(calculator.calculateSpeed(level,baseSpeed));
        battlePokemon.setHp(calculator.calculateHP(level,baseHp));
        battlePokemon.setKo(battlePokemon.getHp() <= 0 ? true : false);
        battlePokemon.setAlive(battlePokemon.getHp() > 0 ? true : false);
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
