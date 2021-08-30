package com.quintatecnica.pokedex.ui.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.quintatecnica.pokedex.R
import com.quintatecnica.pokedex.helper.NumberFormatHelper
import com.quintatecnica.pokedex.model.Pokemon
import com.quintatecnica.pokedex.model.PokemonRepository

class PokemonViewAdapter : RecyclerView.Adapter<PokemonViewAdapter.PokemonViewHolder>() {

    private val pokemonRepository = PokemonRepository()

    private val pokemonList = ArrayList<Pokemon>()

    private val numberFormatHelper = NumberFormatHelper()

    lateinit var onClick: (Pokemon) -> Unit

    private var lastClickedIndex = 0

    private var selectedBackgroundColor: Drawable? = null

    private var unSelectedBackgroundColor: Drawable? = null

    init {
        pokemonRepository.requestPokemon {
            pokemonList.addAll(it)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.pokemon_viewholder, viewGroup, false)
        initBackgroundColor(viewGroup.context)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val currentPokemon = pokemonList[position]
        holder.number.text = numberFormatHelper.formatNumberWith3Digits(currentPokemon.number)
        holder.name.text = currentPokemon.name
        holder.type.text = currentPokemon.type.toString()
        holder.container.setOnClickListener {
            val oldIndex = lastClickedIndex
            lastClickedIndex = position
            if (::onClick.isInitialized) {
                onClick(currentPokemon)
            }
            notifyItemChanged(position)
            notifyItemChanged(oldIndex)
        }
        treatSelectionColor(holder, position)
    }

    private fun treatSelectionColor(holder: PokemonViewHolder, position: Int) {
        val backgroundColor =
            if (lastClickedIndex == position) selectedBackgroundColor else unSelectedBackgroundColor
        holder.container.background = backgroundColor
    }

    override fun getItemCount() = pokemonList.size

    private fun initBackgroundColor(context: Context) {
        selectedBackgroundColor =
            AppCompatResources.getDrawable(context, R.drawable.rounded_view_holder_selected)
        unSelectedBackgroundColor =
            AppCompatResources.getDrawable(context, R.drawable.rounded_view_holder_unselected)
    }

    class PokemonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val container: View = view.findViewById(R.id.container)
        val name: TextView = view.findViewById(R.id.name)
        val number: TextView = view.findViewById(R.id.number)
        val type: TextView = view.findViewById(R.id.type)
    }
}