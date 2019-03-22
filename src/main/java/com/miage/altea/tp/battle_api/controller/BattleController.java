package com.miage.altea.tp.battle_api.controller;

import com.miage.altea.tp.battle_api.bo.Battle;
import com.miage.altea.tp.battle_api.mapper.PokemonMapper;
import com.miage.altea.tp.battle_api.pokemon_info.TrainerInfoService;
import com.miage.altea.tp.battle_api.pokemon_info.bo.PokemonInfo;
import com.miage.altea.tp.battle_api.pokemon_info.bo.TrainerInfo;
import com.miage.altea.tp.battle_api.pokemon_type.bo.PokemonType;
import com.miage.altea.tp.battle_api.pokemon_type.service.PokemonTypeService;
import com.miage.altea.tp.battle_api.service.BattleService;
import com.miage.altea.tp.battle_api.trainer.bo.Pokemon;
import com.miage.altea.tp.battle_api.trainer.bo.Trainer;
import com.miage.altea.tp.battle_api.trainer.service.TrainerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/battle-api")
public class BattleController {

    private PokemonTypeService pokemonTypeService;
    private TrainerService trainerService;
    private BattleService battleService;
    private TrainerInfoService trainerInfoService;

    private PokemonMapper pokemonMapper;

    public BattleController(PokemonTypeService pokemonTypeService, TrainerService trainerService, BattleService battleService, TrainerInfoService trainerInfoService){
        this.pokemonTypeService = pokemonTypeService;
        this.trainerService = trainerService;
        this.battleService = battleService;
        this.trainerInfoService = trainerInfoService;
        pokemonMapper = PokemonMapper.getInstance();
    }

    @GetMapping(value = "/new", params = {"trainer", "opponent"})
    Battle getPokemonTypeFromName(@RequestParam("trainer") String trainerName, @RequestParam("opponent") String opponentName){
        if(trainerName==null || trainerName.isEmpty() || opponentName == null || opponentName.isEmpty()) {
            return null;
        }

        Trainer trainer = this.trainerService.getTrainerByName(trainerName);
        Trainer opponent = this.trainerService.getTrainerByName(opponentName);

        TrainerInfo trainerInfo = trainerInfoService.getTrainerInfo(trainer);
        TrainerInfo opponentInfo = trainerInfoService.getTrainerInfo(opponent);

        Battle battle = battleService.createBattle(trainerInfo, opponentInfo);

        return battle;
    }

}
