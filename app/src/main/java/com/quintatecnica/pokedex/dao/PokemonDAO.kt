package com.quintatecnica.pokedex.dao

import com.quintatecnica.pokedex.model.Pokemon

class PokemonDAO {

    private val pokemonRepository = PokemonRepository()

    private var pokemonList: List<Pokemon>? = null

    fun list(callback: (List<Pokemon>) -> Unit) {
        pokemonList?.let {
            callback(it)
        }

        pokemonRepository.requestPokemon {
            pokemonList = it
            callback(it)
        }
    }
}