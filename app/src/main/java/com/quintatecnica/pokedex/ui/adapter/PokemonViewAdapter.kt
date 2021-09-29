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
import com.quintatecnica.pokedex.dao.PokemonDAO
import com.quintatecnica.pokedex.helper.NumberFormatHelper
import com.quintatecnica.pokedex.model.Pokemon

class PokemonViewAdapter : RecyclerView.Adapter<PokemonViewAdapter.PokemonViewHolder>() {

    private val pokemonDAO = PokemonDAO()

    private val pokemonList = ArrayList<Pokemon>()

    private val numberFormatHelper = NumberFormatHelper()

    lateinit var onClick: (Pokemon) -> Unit

    private var lastClickedIndex = 0

    private var selectedBackgroundColor: Drawable? = null

    private var unSelectedBackgroundColor: Drawable? = null

    private var selectedTextColor: Int? = null

    private var unSelectedTextColor: Int? = null

    init {
        pokemonDAO.list {
            pokemonList.addAll(it)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.pokemon_viewholder, viewGroup, false)
        initBackgroundColor(viewGroup.context)
        initTextColor(viewGroup.context)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val currentPokemon = pokemonList[holder.adapterPosition]
        holder.number.text = numberFormatHelper.formatNumberWith3Digits(currentPokemon.number)
        holder.name.text = currentPokemon.name
        holder.type.text = currentPokemon.type.toString()
        configureClick(holder, currentPokemon)
        treatSelectionColor(holder, holder.adapterPosition)
    }

    private fun configureClick(
        holder: PokemonViewHolder,
        currentPokemon: Pokemon
    ) {
        holder.container.setOnClickListener {
            val oldIndex = lastClickedIndex
            lastClickedIndex = holder.adapterPosition
            if (::onClick.isInitialized) {
                onClick(currentPokemon)
            }
            notifyItemChanged(holder.adapterPosition)
            notifyItemChanged(oldIndex)
        }
    }

    private fun treatSelectionColor(holder: PokemonViewHolder, position: Int) {
        val backgroundColor =
            if (lastClickedIndex == position) selectedBackgroundColor else unSelectedBackgroundColor
        val textColor = if (lastClickedIndex == position) selectedTextColor else unSelectedTextColor
        holder.container.background = backgroundColor
        textColor?.let {
            holder.name.setTextColor(textColor)
            holder.number.setTextColor(textColor)
            holder.type.setTextColor(textColor)
        }
    }

    override fun getItemCount() = pokemonList.size

    private fun initBackgroundColor(context: Context) {
        selectedBackgroundColor =
            AppCompatResources.getDrawable(context, R.drawable.rounded_view_holder_selected)
        unSelectedBackgroundColor =
            AppCompatResources.getDrawable(context, R.drawable.rounded_view_holder_unselected)
    }

    private fun initTextColor(context: Context) {
        selectedTextColor = context.getColor(R.color.white)
        unSelectedTextColor = context.getColor(R.color.black)
    }

    class PokemonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val container: View = view.findViewById(R.id.container)
        val name: TextView = view.findViewById(R.id.name)
        val number: TextView = view.findViewById(R.id.number)
        val type: TextView = view.findViewById(R.id.type)
    }
}