package com.quintatecnica.pokedex.model

import com.quintatecnica.pokedex.model.generator.KantoGenerator

class KantoPokemon {

    private val pokemonList = KantoGenerator().generate()

    fun findByNumber(number: Int) =
        pokemonList.findLast { pokemon ->
            pokemon.number == number
        }

    fun findByName(name: String) =
        pokemonList.findLast { pokemon ->
            pokemon.name.equals(name, true)
        }
}