package com.quintatecnica.pokedex.model

import android.content.Context
import com.quintatecnica.pokedex.R

class Pokemon(
    val number: Int,
    val name: String,
    val type: PokemonType,
) {
    override fun toString() = "$number - $name, $type"

    fun image(context: Context): Int {
        val identifier =
            context.resources.getIdentifier(name.lowercase(), "mipmap", context.packageName)
        return if (identifier == 0) R.mipmap.unkown_pokemon else identifier
    }

    fun description(context: Context): Int {
        val descriptionString = "pokemon_description_${name.lowercase()}"
        val identifier =
            context.resources.getIdentifier(descriptionString, "string", context.packageName)
        return if (identifier == 0) R.string.pokemon_description_missing else identifier
    }
}