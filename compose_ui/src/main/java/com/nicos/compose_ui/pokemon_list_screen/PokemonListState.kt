package com.nicos.compose_ui.pokemon_list_screen

import com.nicos.core.domain.PokemonUi
import com.nicos.database.data.room_database.entities.PokemonEntity

data class PokemonListState(
    val pokemonMutableList: MutableList<PokemonUi>? = null,
    var nextPage: String? = null,
    val isLoading: Boolean = true,
    val error: String? = null,
)