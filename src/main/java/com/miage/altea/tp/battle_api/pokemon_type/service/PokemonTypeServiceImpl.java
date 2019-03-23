package com.miage.altea.tp.battle_api.pokemon_type.service;

import com.miage.altea.tp.battle_api.pokemon_type.bo.PokemonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService{

    RestTemplate restTemplate;

    String pokemonTypeServiceUrl;

    @Override
    public PokemonType getPokemonTypeById(int id) {
        PokemonType pokemonType = restTemplate.getForObject(this.pokemonTypeServiceUrl + "/{id}", PokemonType.class,id );
        return pokemonType;
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${pokemonType.service.url}")
    public void setTrainerServiceUrl(String pokemonTypeServiceUrl) {
        this.pokemonTypeServiceUrl = pokemonTypeServiceUrl;
    }
}
