package com.miage.altea.tp.battle_api.trainer.service;

import com.miage.altea.tp.battle_api.trainer.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TrainerServiceImpl implements TrainerService{

    RestTemplate restTemplate;

    String trainerServiceUrl;

    @Override
    @Cacheable("trainer")
    @Retryable
    public Trainer getTrainerByName(String name) {
        Trainer trainer = restTemplate.getForObject(this.trainerServiceUrl + "/{name}", Trainer.class,name );
        return trainer;
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${trainer.service.url}")
    public void setTrainerServiceUrl(String trainerServiceUrl) {
        this.trainerServiceUrl = trainerServiceUrl;
    }
}
