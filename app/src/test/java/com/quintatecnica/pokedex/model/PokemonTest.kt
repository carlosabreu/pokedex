package com.quintatecnica.pokedex.model

import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito

class PokemonTest {

    private val pikachu = Pokemon(
        25,
        "Pikachu",
        PokemonType.ELECTRIC,
    )

    @Test
    fun should_ReturnPikachuData_WhenCallToString() {
        assertEquals("25 - Pikachu, ELECTRIC", pikachu.toString())
    }

    @Test
    fun should_ReturnPikachuMockedData_WhenCallToString() {
        val pikachu = Mockito.spy(
            Pokemon(
                25,
                "Pikachu",
                PokemonType.ELECTRIC,
            )
        )
        assertEquals("25 - Pikachu, ELECTRIC", pikachu.toString())
        Mockito.`when`(pikachu.toString()).thenReturn("Eu sou o pikachu")
        assertEquals("Eu sou o pikachu", pikachu.toString())
    }
}