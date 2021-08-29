package com.quintatecnica.pokedex.model.generator

import com.quintatecnica.pokedex.R
import com.quintatecnica.pokedex.model.Pokemon
import com.quintatecnica.pokedex.model.PokemonType

class KantoGenerator {

    fun generate(): List<Pokemon> {
        val list = ArrayList<Pokemon>()
        list.addAll(generateList1To10())
        list.addAll(generateList20To30())
        return list
    }

    private fun generateList1To10(): ArrayList<Pokemon> {
        return arrayListOf(
            Pokemon(
                1,
                "Bulbasaur",
                PokemonType.GRASS,
                R.mipmap.bulbasaur,
                R.string.pokemon_description_bulbasaur
            ),
            Pokemon(
                2,
                "Ivysaur",
                PokemonType.GRASS,
                R.mipmap.ivysaur,
                R.string.pokemon_description_ivysaur
            ),
            Pokemon(
                3,
                "Venusaur",
                PokemonType.GRASS,
                R.mipmap.venusayr,
                R.string.pokemon_description_venusaur
            ),
            Pokemon(
                4,
                "Charmander",
                PokemonType.FIRE,
                R.mipmap.charmander,
                R.string.pokemon_description_charmander
            ),
            Pokemon(
                5,
                "Charmeleon",
                PokemonType.FIRE,
                R.mipmap.charmeleon,
                R.string.pokemon_description_charmeleon
            ),
            Pokemon(
                6,
                "Charizard",
                PokemonType.FIRE,
                R.mipmap.charizard,
                R.string.pokemon_description_charizard
            ),
            Pokemon(
                7,
                "Squirtle",
                PokemonType.WATER,
                R.mipmap.squirtle,
                R.string.pokemon_description_squirtle
            ),
            Pokemon(
                8,
                "Wartortle",
                PokemonType.WATER,
                R.mipmap.wartortle,
                R.string.pokemon_description_wartortle
            ),
            Pokemon(
                9,
                "Blastoise",
                PokemonType.WATER,
                R.mipmap.blastoise,
                R.string.pokemon_description_blastoise
            ),
        )
    }

    private fun generateList20To30(): List<Pokemon> {
        return listOf(
            Pokemon(
                25,
                "Pikachu",
                PokemonType.ELECTRIC,
                R.mipmap.pikachu,
                R.string.pokemon_description_pikachu
            )
        )
    }
}