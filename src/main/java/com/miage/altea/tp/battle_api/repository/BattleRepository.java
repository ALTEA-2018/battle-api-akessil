package com.miage.altea.tp.battle_api.repository;

import com.miage.altea.tp.battle_api.bo.Battle;

import java.util.Set;

public interface BattleRepository {
    void saveBattle(Battle battle);
    Set<String> findAll();
    Battle find(String uuid);
}
