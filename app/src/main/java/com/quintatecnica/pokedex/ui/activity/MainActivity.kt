package com.quintatecnica.pokedex.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.quintatecnica.pokedex.R
import com.quintatecnica.pokedex.ui.adapter.PokemonViewAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerview.layoutManager = LinearLayoutManager(this)
        initAdapter()
    }

    private fun initAdapter() {
        val pokemonViewAdapter = PokemonViewAdapter()
        recyclerview.adapter = pokemonViewAdapter
        pokemonViewAdapter.onClick = {
            pokemon_image.setImageResource(it.picture)
            pokemon_description.text = getString(it.description)
        }
    }
}