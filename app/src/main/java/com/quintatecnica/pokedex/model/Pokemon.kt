package com.quintatecnica.pokedex.model

class Pokemon(
    val number: Int,
    val name: String,
    val type: PokemonType,
    val picture: Int,
    val description: Int
) {
    override fun toString() = "$number - $name, $type"
}