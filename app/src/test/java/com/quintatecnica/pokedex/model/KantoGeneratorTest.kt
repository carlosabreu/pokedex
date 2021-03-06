package com.quintatecnica.pokedex.model

import com.quintatecnica.pokedex.generator.KantoGenerator
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.hamcrest.core.Is
import org.junit.Assert.*
import org.junit.Test

class KantoGeneratorTest {

    private val numberOfPokemon = 10

    @Test
    fun should_ReturnTheNumberOfPokemon_WhenGenerateList() {
        assertEquals(numberOfPokemon, KantoGenerator().generate().size)
    }

    @Test
    fun should_ReturnBulbasaur_WhenSearchForNumberOne() {
        assertEquals("Bulbasaur", KantoGenerator().generate()[0].name)
        assertThat("Bulbasaur", Is(equalTo(KantoGenerator().generate()[0].name)))
    }
}