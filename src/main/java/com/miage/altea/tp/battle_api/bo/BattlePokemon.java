package com.miage.altea.tp.battle_api.bo;

import com.miage.altea.tp.battle_api.pokemon_type.bo.PokemonType;

public class BattlePokemon {
    private int id;

    private PokemonType pokemonType;

    private int level;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PokemonType getPokemonType() {
        return pokemonType;
    }

    public void setPokemonType(PokemonType pokemonType) {
        this.pokemonType = pokemonType;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
