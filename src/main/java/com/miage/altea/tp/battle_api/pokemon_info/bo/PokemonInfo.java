package com.miage.altea.tp.battle_api.pokemon_info.bo;

import com.miage.altea.tp.battle_api.pokemon_type.bo.PokemonType;

public class PokemonInfo {
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
