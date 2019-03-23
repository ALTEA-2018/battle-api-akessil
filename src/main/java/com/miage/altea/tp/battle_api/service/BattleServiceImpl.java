package com.miage.altea.tp.battle_api.service;

import com.miage.altea.tp.battle_api.bo.Battle;
import com.miage.altea.tp.battle_api.bo.BattleTrainer;
import com.miage.altea.tp.battle_api.pokemon_info.bo.TrainerInfo;
import com.miage.altea.tp.battle_api.repository.BattleRepository;
import com.miage.altea.tp.battle_api.service.factory.BattlePokemonFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class BattleServiceImpl implements BattleService {
    private final BattlePokemonFactory battlePokemonFactory;
    private BattleRepository battleRepository;

    public BattleServiceImpl(BattleRepository battleRepository){
        this.battlePokemonFactory =  BattlePokemonFactory.getInstance();
        this.battleRepository = battleRepository;
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

        this.battleRepository.saveBattle(battle);
        return battle;
    }

    @Override
    public Set<String> getAllBattles() {
        return battleRepository.findAll();
    }
    @Override
    public Battle findBattle(String uuid) {
        return battleRepository.find(uuid);
    }

}
