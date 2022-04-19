package com.example.pokemonChallenge.controller;

import com.example.pokemonChallenge.model.Pokemon;
import com.example.pokemonChallenge.service.PokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/")
public class PokeController {

    @Autowired
    private PokeService pokeService;

    @GetMapping("/pokemons")
    public List<Pokemon> getPokemonWithSubstring(@RequestParam("q") String substring) {
        return pokeService.searchWithSubstring(substring);
    }

}
