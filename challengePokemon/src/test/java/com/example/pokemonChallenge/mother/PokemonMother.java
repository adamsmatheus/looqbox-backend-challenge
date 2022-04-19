package com.example.pokemonChallenge.mother;

import com.example.pokemonChallenge.model.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class PokemonMother {

    public ArrayList<Pokemon> getPokemonList() {

        ArrayList<Pokemon> list = new ArrayList<>();
        Pokemon pokemon = new Pokemon();

        pokemon.setName("Bulbasaur");
        list.add(pokemon);

        pokemon.setName("Pidgey");
        list.add(pokemon);

        pokemon.setName("Venossaur");
        list.add(pokemon);

        pokemon.setName("Pidgeotto");
        list.add(pokemon);

        pokemon.setName("Pidgeot");
        list.add(pokemon);

        pokemon.setName("Charmander");
        list.add(pokemon);

        pokemon.setName("Charmilion");
        list.add(pokemon);

        pokemon.setName("Charizard");
        list.add(pokemon);

        return list;
    }
}
