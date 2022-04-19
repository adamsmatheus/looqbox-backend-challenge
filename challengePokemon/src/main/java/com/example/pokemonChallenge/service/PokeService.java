package com.example.pokemonChallenge.service;

import com.example.pokemonChallenge.model.PokemonList;
import com.example.pokemonChallenge.model.Pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokeService {

    private static final String URL = "https://pokeapi.co/api/v2/pokemon/";
    private static final String PRE_BEFORE = "<pre>";
    private static final String PRE_AFTER = "</pre>";

    @Autowired
    private RestTemplate template = new RestTemplate();

    public List<Pokemon> searchWithSubstring(String subString) {

        //Get the Pokemon List.
        PokemonList pokemonList = template.getForObject(URL, PokemonList.class);

        // Check each pokemon in the pokemonList
        // contains the subString that came in the request
        List<Pokemon> list = verifyPokemonSubstring(pokemonList, subString);

        sortPokemonByAlphabetical(list);
        sortPokemonByLength(list);
        return list;
    }

    private List<Pokemon> verifyPokemonSubstring(PokemonList pokemonList, String subString) {
        List<Pokemon> list = new ArrayList<>();

        for (Pokemon pokemon : pokemonList.getResults()) {
            if (pokemon.getName().contains(subString)) {
                // This method add <pre> tag and </pre> tag in pokemon name.
                setPokemonNameWithHighlight(pokemon, subString);
                list.add(pokemon);
            }
        }
        return list;
    }

    private List<Pokemon> sortPokemonByLength(List<Pokemon> pokemons) {

        Pokemon pokemonAux;
        for (int i = 0; i < pokemons.size()-1; i++) {
            // The min variable save the index that contains the smallest value.
            // For this method we compare the Strings and check which one is smaller.
            int min = i;

            for (int j = i+1; j < pokemons.size(); j++) {

                // In the condition, we compare the String at index min and index j.
                // If the String in index min is greater than the string in index j, we assign the index of j as the smallest.
                if (pokemons.get(j).getName().length() < pokemons.get(min).getName().length()) {
                    min = j;
                }

                pokemonAux = pokemons.get(min);
                pokemons.set(min, pokemons.get(i));
                pokemons.set(i, pokemonAux);
            }
        }
        return pokemons;
    }

    private List<Pokemon> sortPokemonByAlphabetical(List<Pokemon> pokemons) {
        // For this method, we compare a pokemon String with pokemonAux
        // String, using the CompareTo() method,
        // which returns a result greater than 0, it means that the String
        // passed by parameter comes before than the value on which we are calling the method.
        // This way we change the order of the names.

        Pokemon pokemonAux;
        for (int i = 0; i < pokemons.size()-1; i++) {
            for (int j = i+1; j < pokemons.size(); j++) {

                if (pokemons.get(i).getName().compareTo(pokemons.get(j).getName()) > 0) {
                    pokemonAux = pokemons.get(i);
                    pokemons.set(i, pokemons.get(j));
                    pokemons.set(j, pokemonAux);
                }
            }
        }
        return pokemons;
    }

    private void setPokemonNameWithHighlight(Pokemon pokemon, String substring) {

        String namePokemon = pokemon.getName();
        int index = namePokemon.indexOf(substring);

        // For this method add the tags at the beginning and at the end of the string
        // as soon as we find the substring inside the checked string we place the
        // <pre> tag before and the </pre> tag after the substring.
        String stringHighlight = PRE_BEFORE + namePokemon.substring(index, index + substring.length()) + PRE_AFTER;

        String before = namePokemon.substring(0, index);
        String after = namePokemon.substring(before.length()+1 + stringHighlight.length()-12);
        String replacement = before + stringHighlight + after;
        String highlight = namePokemon.replace(namePokemon, replacement);
        pokemon.setNameWithHighlight(highlight);
    }



}
