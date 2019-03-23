package com.miage.altea.tp.battle_api.pokemon_info;

import com.miage.altea.tp.battle_api.mapper.PokemonMapper;
import com.miage.altea.tp.battle_api.mapper.TrainerMapper;
import com.miage.altea.tp.battle_api.pokemon_info.bo.PokemonInfo;
import com.miage.altea.tp.battle_api.pokemon_info.bo.TrainerInfo;
import com.miage.altea.tp.battle_api.pokemon_type.bo.PokemonType;
import com.miage.altea.tp.battle_api.pokemon_type.service.PokemonTypeService;
import com.miage.altea.tp.battle_api.trainer.bo.Pokemon;
import com.miage.altea.tp.battle_api.trainer.bo.Trainer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainerInfoServiceImpl implements TrainerInfoService{
    private PokemonTypeService pokemonTypeService;

    private PokemonMapper pokemonMapper;
    private TrainerMapper trainerMapper;

    public TrainerInfoServiceImpl(PokemonTypeService pokemonTypeService){
        this.pokemonTypeService = pokemonTypeService;
        this.pokemonMapper = PokemonMapper.getInstance();
        this.trainerMapper = TrainerMapper.getInstance();
    }

    @Override
    public TrainerInfo getTrainerInfo(Trainer trainer) {
        List<Pokemon> pokemons = trainer.getTeam();
        List<PokemonInfo> pokemonsInfo = new ArrayList<>();

        for(Pokemon pokemon : pokemons) {
            PokemonType pokemonType = pokemonTypeService.getPokemonTypeById(pokemon.getPokemonType());
            PokemonInfo pokemonInfo = pokemonMapper.pokemonToPokemonInfo(pokemon,pokemonType);
            pokemonsInfo.add(pokemonInfo);
        }

        return trainerMapper.trainerToTrainerInfo(trainer, pokemonsInfo);
    }
}
