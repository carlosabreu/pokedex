package com.quintatecnica.pokedex.model

import org.junit.Assert
import org.junit.Test

class KantoPokemonTest {

    private val kantoPokemon = KantoPokemon()

    @Test
    fun should_ReturnBulbasaur_WhenSearchForNumberOne() {
        Assert.assertEquals("Bulbasaur", kantoPokemon.findByNumber(1)?.name)
    }

    @Test
    fun should_ReturnPikachu_WhenSearchForNumberOne() {
        Assert.assertEquals(25, kantoPokemon.findByName("pikachu")?.number)
    }
}