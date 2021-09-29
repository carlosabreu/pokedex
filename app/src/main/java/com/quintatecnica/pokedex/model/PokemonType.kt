package com.quintatecnica.pokedex.model

import android.content.Context
import com.quintatecnica.pokedex.R

enum class PokemonType(val color: String) {
    GRASS("emerland"), WATER("teal_200"), FIRE("pumpkin"), ELECTRIC("sunflower");

    fun colorResource(context: Context): Int {
        val identifier =
            context.resources.getIdentifier(color, "color", context.packageName)
        return if (identifier == 0) R.color.white else identifier
    }
}