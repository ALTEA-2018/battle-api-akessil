package com.miage.altea.tp.battle_api.pokemon_info.bo;

import com.miage.altea.tp.battle_api.trainer.bo.Pokemon;

import java.util.List;

public class TrainerInfo {

    private String name;

    private List<PokemonInfo> team;

    public TrainerInfo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PokemonInfo> getTeam() {
        return team;
    }

    public void setTeam(List<PokemonInfo> team) {
        this.team = team;
    }
}
