package com.miage.altea.tp.battle_api.repository;

import com.miage.altea.tp.battle_api.bo.Battle;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BattleRepositoryImpl implements BattleRepository{

    private Map<String,Battle> battles = new HashMap<>();

    @Override
    public void saveBattle(Battle battle) {
        if(battle == null) {
            return;
        }
        battles.put(battle.getUuid(),battle);
    }
}
