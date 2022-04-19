package com.example.pokemonChallenge.service;

import com.example.pokemonChallenge.model.Pokemon;
import com.example.pokemonChallenge.mother.PokemonMother;


import org.springframework.beans.factory.annotation.Autowired;

import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;



public class PokemonServiceTest {

    @Autowired
    private PokemonMother pokemonMother;

    @Test
    public void shouldReturnWithHighlightBySubString() {

        PokeService pokeService = new PokeService();
        Pokemon pokemon = new Pokemon();

        ArrayList<Pokemon> list = new ArrayList<>();
        String subString = "pi";

        pokemon.setName("Pidgey");
        pokemon.setNameWithHighlight("<pre>pi</pre>dgey");
        list.add(pokemon);

        pokemon.setName("Pidgeot");
        pokemon.setNameWithHighlight("<pre>pi</pre>dgeot");
        list.add(pokemon);

        List<Pokemon> result = pokeService.searchWithSubstring(subString);

        org.junit.Assert.assertNotNull(result);
        org.junit.Assert.assertEquals(list.get(0).getNameWithHighlight(),result.get(1).getNameWithHighlight());



    }

    @Test
    public void shouldReturnAllTheNameWithHighlightNull() {

        PokeService pokeService = new PokeService();
        String subString = "ppp";

        List<Pokemon> result = pokeService.searchWithSubstring(subString);

        org.junit.Assert.assertNotNull(result);
        org.junit.Assert.assertEquals(result.size(),0);

    }


}


