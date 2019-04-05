package com.miage.altea.tp.battle_api.service;

import com.miage.altea.tp.battle_api.bo.Battle;
import com.miage.altea.tp.battle_api.bo.BattlePokemon;
import com.miage.altea.tp.battle_api.bo.BattleTrainer;
import com.miage.altea.tp.battle_api.pokemon_info.bo.TrainerInfo;
import com.miage.altea.tp.battle_api.repository.BattleRepository;
import com.miage.altea.tp.battle_api.service.util.AttackCalculator;
import com.miage.altea.tp.battle_api.service.util.BattlePokemonFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
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

        if(getFirstAlive(battleTrainer.getTeam()).getSpeed() >= getFirstAlive(battleOpponent.getTeam()).getSpeed()) {
            battleTrainer.setNextTurn(true);
            battleOpponent.setNextTurn(false);
        } else {
            battleTrainer.setNextTurn(false);
            battleOpponent.setNextTurn(true);
        }

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
    public ResponseEntity attack(String uuid, String trainerName) {
        Battle battle = battleRepository.find(uuid);
        if(battle == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Battle Not Found");
        }

        BattleTrainer attacker = battle.getTrainer().getName().equals(trainerName) ? battle.getTrainer() : (battle.getOpponent().getName().equals(trainerName) ? battle.getOpponent() : null);

        if(attacker == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The trainer is not part of the battle");
        }

        if(! attacker.getNextTurn()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("It's your opponent's turn");
        }

        BattleTrainer victim = attacker.getName().equals(trainerName) ? battle.getOpponent() : battle.getTrainer();

        BattlePokemon pokemonAttacker = this.getFirstAlive(battle.getTrainer().getTeam());
        BattlePokemon pokemonVictim = this.getFirstAlive(battle.getOpponent().getTeam());

        int pokemonAttackLevel = pokemonAttacker.getLevel();
        int pokemonAttack = pokemonAttacker.getAttack();
        int pokemonDefense = pokemonVictim.getDefense();

        int damages = attackCalculator.calculateDamages(pokemonAttackLevel, pokemonAttack, pokemonDefense);
        int hp = pokemonVictim.getHp() - damages;
        hp = hp > 0 ? hp : 0;
        pokemonVictim.setHp(hp);
        pokemonVictim.setAlive(hp > 0);
        pokemonVictim.setKo(hp <= 0);

        attacker.setNextTurn(false);
        victim.setNextTurn(true);

        battleRepository.saveBattle(battle);
        return ResponseEntity.status(HttpStatus.OK).body(battle);
    }

    private BattlePokemon getFirstAlive(List<BattlePokemon> pokemons){
        for (BattlePokemon pokemon : pokemons) {
            if(pokemon.getAlive()) {
                return  pokemon;
            }
        }
        return null;
    }

}
