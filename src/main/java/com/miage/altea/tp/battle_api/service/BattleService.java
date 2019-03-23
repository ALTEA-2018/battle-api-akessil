package com.miage.altea.tp.battle_api.service;

import com.miage.altea.tp.battle_api.bo.Battle;
import com.miage.altea.tp.battle_api.pokemon_info.bo.TrainerInfo;

import java.util.Set;

public interface BattleService {
    Battle createBattle(TrainerInfo trainer, TrainerInfo opponent);
    Set<String> getAllBattles();
}
