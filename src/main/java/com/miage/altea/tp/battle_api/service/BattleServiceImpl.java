package com.miage.altea.tp.battle_api.service;

import com.miage.altea.tp.battle_api.bo.Battle;
import com.miage.altea.tp.battle_api.bo.BattlePokemon;
import com.miage.altea.tp.battle_api.bo.BattleTrainer;
import com.miage.altea.tp.battle_api.pokemon_info.bo.TrainerInfo;
import com.miage.altea.tp.battle_api.repository.BattleRepository;
import com.miage.altea.tp.battle_api.service.factory.AttackCalculator;
import com.miage.altea.tp.battle_api.service.factory.BattlePokemonFactory;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class BattleServiceImpl implements BattleService {
    private BattleRepository battleRepository;
    private final BattlePokemonFactory battlePokemonFactory;
    private AttackCalculator attackCalculator;

    public BattleServiceImpl(BattleRepository battleRepository){
        this.battleRepository = battleRepository;
        this.battlePokemonFactory =  BattlePokemonFactory.getInstance();
        attackCalculator = AttackCalculator.getInstance();
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

    @Override
    public Battle attack(String uuid, String trainerName) {
        Battle battle = battleRepository.find(uuid);
        BattlePokemon pokemonAttacker = battle.getTrainer().getTeam().get(0);
        BattlePokemon pokemonVictim = battle.getOpponent().getTeam().get(0);

        int pokemonAttackLevel = pokemonAttacker.getLevel();
        int pokemonAttack = pokemonAttacker.getAttack();
        int pokemonDefense = pokemonVictim.getDefense();

        int damages = attackCalculator.calculateDamages(pokemonAttackLevel, pokemonAttack, pokemonDefense);
        int hp = pokemonVictim.getHp() - damages;
        hp = hp > 0 ? hp : 0;
        pokemonVictim.setHp(hp);

        battleRepository.saveBattle(battle);
        return battle;
    }

}
