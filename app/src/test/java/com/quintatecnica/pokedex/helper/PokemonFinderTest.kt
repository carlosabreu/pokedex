package com.quintatecnica.pokedex.helper

import android.content.Context
import com.quintatecnica.pokedex.generator.KantoGenerator
import com.quintatecnica.pokedex.mocks.PokemonListMock
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito

class PokemonFinderTest {

    @Test
    fun should_return0Pokemon_whenSearchForPikachu123() {
        val kantoPokemonList = KantoGenerator().generate()
        val result = PokemonFinder().searchByName(kantoPokemonList, "pikachu123")
        assertEquals(0, result.size)
    }

    @Test
    fun should_return1Pokemon_whenSearchForPikachu() {
        val kantoPokemonList = KantoGenerator().generate()
        val result = PokemonFinder().searchByName(kantoPokemonList, "pikachu")
        assertEquals(1, result.size)
    }

    @Test
    fun should_return1Pokemon_whenSearchByNumber() {
        val kantoPokemonList = KantoGenerator().generate()
        val result = PokemonFinder().searchByNumber(kantoPokemonList, 1)
        assertEquals(1, result.size)
        assertEquals("Bulbasaur", result[0].name)
    }

    @Test
    fun should_returnSquirtle_whenSearchByDescription() {
        val context = Mockito.mock(Context::class.java)
        val pokemonList = PokemonListMock().mockPokemonList(context)
        val result = PokemonFinder().searchByDescription(
            context,
            pokemonList,
            "transforma em wartortle primeiro"
        )
        assertEquals(1, result.size)
        assertEquals("Squirtle", result[0].name)
    }

    @Test
    fun should_return_whenSearch() {
        val context = Mockito.mock(Context::class.java)
        val pokemonList = PokemonListMock().mockPokemonList(context)
        val result = PokemonFinder().search(
            context,
            pokemonList,
            "Squirtle"
        )
        assertEquals(2, result.size)
        assertEquals("Squirtle", result[0].name)
        assertEquals("Wartortle", result[1].name)
    }

    @Test
    fun should_returnBulbasaur_whenSearchFor1() {
        val context = Mockito.mock(Context::class.java)
        val pokemonList = PokemonListMock().mockPokemonList(context)
        val result = PokemonFinder().search(
            context,
            pokemonList,
            "1"
        )
        assertEquals(1, result.size)
        assertEquals("Bulbasaur", result[0].name)
    }
}