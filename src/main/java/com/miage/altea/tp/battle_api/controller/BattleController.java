package com.miage.altea.tp.battle_api.controller;

import com.miage.altea.tp.battle_api.bo.Battle;
import com.miage.altea.tp.battle_api.input.CreatebattleInput;
import com.miage.altea.tp.battle_api.mapper.PokemonMapper;
import com.miage.altea.tp.battle_api.pokemon_info.TrainerInfoService;
import com.miage.altea.tp.battle_api.pokemon_info.bo.TrainerInfo;
import com.miage.altea.tp.battle_api.pokemon_type.service.PokemonTypeService;
import com.miage.altea.tp.battle_api.service.BattleService;
import com.miage.altea.tp.battle_api.trainer.bo.Trainer;
import com.miage.altea.tp.battle_api.trainer.service.TrainerService;
import org.apache.tomcat.util.descriptor.tld.TldRuleSet;
import org.jboss.logging.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/battles")
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

    @PostMapping(value = "")
    public String createNewBattle(@RequestBody CreatebattleInput input){
        if(input == null || input.getTrainer()==null || input.getTrainer().isEmpty() || input.getOpponent() == null || input.getOpponent().isEmpty()) {
            return null;
        }

        Trainer trainer = this.trainerService.getTrainerByName(input.getTrainer());
        Trainer opponent = this.trainerService.getTrainerByName(input.getOpponent());

        TrainerInfo trainerInfo = trainerInfoService.getTrainerInfo(trainer);
        TrainerInfo opponentInfo = trainerInfoService.getTrainerInfo(opponent);

        Battle battle = battleService.createBattle(trainerInfo, opponentInfo);

        return battle.getUuid();
    }

    @PostMapping(value = "", params = {"trainer","opponent"})
    public String createNewBattle2(@RequestParam("trainer") String trainer, @RequestParam("opponent") String opponent){
        CreatebattleInput input = new CreatebattleInput();
        input.setOpponent(opponent);
        input.setTrainer(trainer);

        return createNewBattle(input);
    }

    @GetMapping("")
    public Set<String> getAllBattles(){
        return battleService.getAllBattles();
    }

    @GetMapping("/{uuid}")
    public Battle getAllBattle(@PathVariable String uuid){
        if(uuid == null || uuid.isEmpty()) {
            return null;
        }
        return  battleService.findBattle(uuid);
    }

    @PostMapping("/{uuid}/{trainerName}/attack")
    public ResponseEntity attack(@PathVariable String uuid, @PathVariable String trainerName){
        return battleService.attack(uuid, trainerName);

    }
}
