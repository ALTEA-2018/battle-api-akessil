package com.miage.altea.tp.battle_api.trainer.service;

import com.miage.altea.tp.battle_api.trainer.bo.Trainer;

public interface TrainerService {

    Trainer getTrainerByName(final String name);
}
