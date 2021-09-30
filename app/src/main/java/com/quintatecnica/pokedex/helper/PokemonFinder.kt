package com.quintatecnica.pokedex.helper

import android.content.Context
import com.quintatecnica.pokedex.model.Pokemon

class PokemonFinder {

    fun searchByName(listOfPokemon: List<Pokemon>, searchInput: String): List<Pokemon> {
        val filteredList = listOfPokemon.filter {
            it.name.lowercase() == searchInput.lowercase()
        }
        return filteredList
    }

    fun searchByNumber(listOfPokemon: List<Pokemon>, number: Int): List<Pokemon> {
        val filteredList = listOfPokemon.filter {
            it.number == number
        }
        return filteredList
    }

    fun searchByDescription(
        context: Context,
        listOfPokemon: List<Pokemon>,
        searchInput: String
    ): List<Pokemon> {
        val filteredList = listOfPokemon.filter {
            it.description(context).lowercase().contains(searchInput)
        }
        return filteredList
    }
}