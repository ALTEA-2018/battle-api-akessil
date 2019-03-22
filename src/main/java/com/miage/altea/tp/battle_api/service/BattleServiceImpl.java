package com.miage.altea.tp.battle_api.service;

import com.miage.altea.tp.battle_api.bo.Battle;
import com.miage.altea.tp.battle_api.bo.BattleTrainer;
import com.miage.altea.tp.battle_api.pokemon_info.bo.TrainerInfo;
import com.miage.altea.tp.battle_api.service.factory.BattlePokemonFactory;

import java.util.UUID;

public class BattleServiceImpl implements BattleService {
    private final BattlePokemonFactory battlePokemonFactory;

    public BattleServiceImpl(){
        this.battlePokemonFactory =  BattlePokemonFactory.getInstance();
    }

    @Override
    public Battle createBattle(TrainerInfo trainer, TrainerInfo opponent) {
        UUID uuid = UUID.randomUUID();
        Battle battle = new Battle(uuid.toString());

        BattleTrainer battleTrainer = new BattleTrainer(trainer.getName());
        battleTrainer.setTeam(battlePokemonFactory.getBattlePokemons(trainer.getTeam()));

        BattleTrainer battleOpponent = new BattleTrainer(opponent.getName());
        battleOpponent.setTeam(battlePokemonFactory.getBattlePokemons(opponent.getTeam()));

        battle.setTrainer(battleTrainer);
        battle.setOpponent(battleOpponent);
        return battle;
    }
}
