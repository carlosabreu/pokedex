package com.quintatecnica.pokedex.dao

import com.quintatecnica.pokedex.generator.Generator
import com.quintatecnica.pokedex.generator.JohtoGenerator
import com.quintatecnica.pokedex.generator.KantoGenerator
import com.quintatecnica.pokedex.model.Pokemon

class PokemonRepository {
    fun requestPokemon(callback: (List<Pokemon>) -> Unit) {
        generate(KantoGenerator(), callback)
        generate(JohtoGenerator(), callback)
    }

    fun generate(generator: Generator, callback: (List<Pokemon>) -> Unit) {
        val generated = generator.generate()
        if (generated.isNotEmpty() && generated.size != 0) {
            callback(generated)
        }
    }
}