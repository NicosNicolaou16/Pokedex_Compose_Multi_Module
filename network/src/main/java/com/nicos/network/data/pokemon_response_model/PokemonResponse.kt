package com.nicos.network.data.pokemon_response_model

import com.google.gson.annotations.SerializedName
import com.nicos.database.data.room_database.entities.PokemonEntity

data class PokemonResponse(
    @SerializedName("next") val nextUrl: String?,
    @SerializedName("results") val results: MutableList<PokemonEntity>
) {
}