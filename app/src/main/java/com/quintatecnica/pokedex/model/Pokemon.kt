package com.quintatecnica.pokedex.model

import android.content.Context

class Pokemon(
    val number: Int,
    val name: String,
    val type: PokemonType,
) {
    override fun toString() = "$number - $name, $type"

    fun image(context: Context): Int {
        return context.resources.getIdentifier(name.lowercase(), "mipmap", context.packageName)
    }

    fun description(context: Context): Int {
        val descriptionString = "pokemon_description_${name.lowercase()}"
        return context.resources.getIdentifier(descriptionString, "string", context.packageName)
    }
}