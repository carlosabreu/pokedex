package com.quintatecnica.pokedex.generator

import com.quintatecnica.pokedex.model.Pokemon
import com.quintatecnica.pokedex.model.PokemonType

class KantoGenerator : Generator {

    override fun generate() = ArrayList<Pokemon>().also {
        it.addAll(generateList1To10())
        it.addAll(generateList20To30())
    }

    private fun generateList1To10() = listOf(
        Pokemon(
            1,
            "Bulbasaur",
            PokemonType.GRASS,
        ),
        Pokemon(
            2,
            "Ivysaur",
            PokemonType.GRASS,
        ),
        Pokemon(
            3,
            "Venusaur",
            PokemonType.GRASS,
        ),
        Pokemon(
            4,
            "Charmander",
            PokemonType.FIRE,
        ),
        Pokemon(
            5,
            "Charmeleon",
            PokemonType.FIRE,
        ),
        Pokemon(
            6,
            "Charizard",
            PokemonType.FIRE,
        ),
        Pokemon(
            7,
            "Squirtle",
            PokemonType.WATER,
        ),
        Pokemon(
            8,
            "Wartortle",
            PokemonType.WATER,
        ),
        Pokemon(
            9,
            "Blastoise",
            PokemonType.WATER,
        ),
    )

    private fun generateList20To30() = listOf(
        Pokemon(
            25,
            "Pikachu",
            PokemonType.ELECTRIC,
        )
    )
}