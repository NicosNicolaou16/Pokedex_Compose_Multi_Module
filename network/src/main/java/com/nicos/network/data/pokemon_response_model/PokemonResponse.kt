package com.nicos.network.data.pokemon_response_model

import com.google.gson.annotations.SerializedName
import com.nicos.network.data.dto.PokemonDto

data class PokemonResponse(
    @SerializedName("next") val nextUrl: String?,
    @SerializedName("results") val results: MutableList<PokemonDto>
) {
}