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

    fun searchByNumber(listOfPokemon: List<Pokemon>, searchInput: String) =
        searchInput.toIntOrNull()?.let { searchByNumber(listOfPokemon, it) }
            ?: listOf()

    fun searchByDescription(
        context: Context,
        listOfPokemon: List<Pokemon>,
        searchInput: String
    ): List<Pokemon> {
        val filteredList = listOfPokemon.filter {
            it.description(context).lowercase().contains(searchInput.lowercase())
        }
        return filteredList
    }

    fun search(context: Context, listOfPokemon: List<Pokemon>, searchInput: String) =
        ArrayList<Pokemon>(
            HashSet<Pokemon>().apply {
                addAll(searchByDescription(context, listOfPokemon, searchInput))
                addAll(searchByName(listOfPokemon, searchInput))
                addAll(searchByNumber(listOfPokemon, searchInput))
            }).sortedBy { it.number }
}