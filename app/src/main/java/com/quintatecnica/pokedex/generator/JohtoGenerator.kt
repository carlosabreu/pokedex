package com.quintatecnica.pokedex.generator

import com.quintatecnica.pokedex.R
import com.quintatecnica.pokedex.model.Pokemon
import com.quintatecnica.pokedex.model.PokemonType

class JohtoGenerator : Generator {

    override fun generate() = ArrayList<Pokemon>().also {
        it.addAll(generateList1To10())
    }

    private fun generateList1To10() = arrayListOf(
        Pokemon(
            151,
            "Chikorita",
            PokemonType.GRASS,
        )
    )
}