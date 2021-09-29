package com.quintatecnica.pokedex.dao

import com.quintatecnica.pokedex.generator.KantoGenerator
import com.quintatecnica.pokedex.model.Pokemon
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.never

class PokemonRepositoryTest {

    private val repository = PokemonRepository()

    @Test
    fun should_CallCallback_WhenPokemonIsGenerated() {
        val function: (List<Pokemon>) -> Unit = {}
        val callback = Mockito.mock(function::class.java)
        repository.generate(KantoGenerator(), callback)
        Mockito.verify(callback)(Mockito.anyList())
    }

    @Test
    fun should_NotCallCallback_WhenPokemonNoPokemonIsGenerated() {
        val function: (List<Pokemon>) -> Unit = {}
        val callback = Mockito.mock(function::class.java)
        val generator = Mockito.mock(KantoGenerator::class.java)
        Mockito.`when`(generator.generate()).thenReturn(ArrayList())
        repository.generate(generator, callback)
        Mockito.verify(callback, never())(Mockito.anyList())
    }
}