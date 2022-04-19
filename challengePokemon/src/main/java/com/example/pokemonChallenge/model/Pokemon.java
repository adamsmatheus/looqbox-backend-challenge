package com.example.pokemonChallenge.model;

import lombok.*;
import org.springframework.boot.context.properties.ConstructorBinding;

import javax.management.ConstructorParameters;



@RequiredArgsConstructor
@Getter
@Setter
public class Pokemon {

    private String name;
    private String nameWithHighlight;

}