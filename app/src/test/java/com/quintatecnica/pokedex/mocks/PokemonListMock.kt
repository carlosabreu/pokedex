package com.quintatecnica.pokedex.mocks

import android.content.Context
import com.quintatecnica.pokedex.model.Pokemon
import com.quintatecnica.pokedex.model.PokemonType
import org.mockito.Mockito

class PokemonListMock {
    fun mockPokemonList(context: Context): List<Pokemon> {
        val bulbasaur = Mockito.spy(Pokemon(1, "Bulbasaur", PokemonType.GRASS))
        Mockito.doAnswer { "Bulbassauro" }.`when`(bulbasaur).description(context)
        val pikachu = Mockito.spy(Pokemon(25, "Pikachu", PokemonType.ELECTRIC))
        Mockito.doAnswer { "Pikachu é um pokemon elétrico" }.`when`(pikachu).description(context)
        val squirtle = Mockito.spy(Pokemon(7, "Squirtle", PokemonType.WATER))
        Mockito.doAnswer { "Squirtle é um pokémon de tipo água se transforma em wartortle primeiro e em blastoise mais tarde." }
            .`when`(squirtle).description(context)
        val wartortle = Mockito.spy(Pokemon(8, "Wartortle", PokemonType.WATER))
        Mockito.doAnswer { "Wartortle é um pokémon de tipo água que vem de squirtle e pode evoluir para blastoise. ." }
            .`when`(wartortle).description(context)
        return listOf(bulbasaur, pikachu, squirtle, wartortle)
    }
}