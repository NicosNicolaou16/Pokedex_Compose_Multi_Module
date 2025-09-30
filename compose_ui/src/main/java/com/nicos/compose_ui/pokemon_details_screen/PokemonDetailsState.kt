package com.nicos.compose_ui.pokemon_details_screen

import com.nicos.database.pokemon_details_data_model.PokemonDetailsDataModel

data class PokemonDetailsState(
    val pokemonDetailsDataModelList: MutableList<PokemonDetailsDataModel>,
    val isLoading: Boolean = true,
    val error: String? = null,
)