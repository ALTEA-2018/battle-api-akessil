package com.miage.altea.tp.battle_api.pokemon_info;

import com.miage.altea.tp.battle_api.pokemon_info.bo.TrainerInfo;
import com.miage.altea.tp.battle_api.trainer.bo.Trainer;

public interface TrainerInfoService {
    TrainerInfo getTrainerInfo(Trainer trainer);
}
