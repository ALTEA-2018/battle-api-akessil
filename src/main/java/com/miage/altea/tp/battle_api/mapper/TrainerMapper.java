package com.miage.altea.tp.battle_api.mapper;

import com.miage.altea.tp.battle_api.pokemon_info.bo.PokemonInfo;
import com.miage.altea.tp.battle_api.pokemon_info.bo.TrainerInfo;
import com.miage.altea.tp.battle_api.trainer.bo.Trainer;

import java.util.List;

public class TrainerMapper {
    private static TrainerMapper INSTANCE = new TrainerMapper();

    private TrainerMapper(){};

    public static TrainerMapper getInstance(){
        return INSTANCE;
    }

    public TrainerInfo trainerToTrainerInfo(Trainer trainer , List<PokemonInfo> pokemons){
        if(trainer == null) {
            return null;
        }

        TrainerInfo trainerInfo = new TrainerInfo(trainer.getName());
        trainerInfo.setTeam(pokemons);

        return trainerInfo;

    }

}
