package com.miage.altea.tp.battle_api.mapper;

import com.miage.altea.tp.battle_api.pokemon_info.bo.PokemonInfo;
import com.miage.altea.tp.battle_api.pokemon_type.bo.PokemonType;
import com.miage.altea.tp.battle_api.trainer.bo.Pokemon;

public class PokemonMapper {
    private static PokemonMapper INSTANCE = new PokemonMapper();
    private PokemonMapper(){};

    public static PokemonMapper getInstance(){
        return INSTANCE;
    }

    public PokemonInfo pokemonToPokemonInfo(Pokemon pokemon, PokemonType pokemonType){
        PokemonInfo pokemonInfo = new PokemonInfo();
        pokemonInfo.setId(pokemon.getId());
        pokemonInfo.setLevel(pokemon.getLevel());
        pokemonInfo.setPokemonType(pokemonType);

        return pokemonInfo;
    }
}
