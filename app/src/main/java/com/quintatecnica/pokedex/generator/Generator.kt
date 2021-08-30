package com.quintatecnica.pokedex.generator

import com.quintatecnica.pokedex.model.Pokemon

interface Generator {
    fun generate(): ArrayList<Pokemon>
}