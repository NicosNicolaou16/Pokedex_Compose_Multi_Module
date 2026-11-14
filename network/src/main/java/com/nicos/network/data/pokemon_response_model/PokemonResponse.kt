package com.nicos.network.data.pokemon_response_model

import com.nicos.network.data.dto.PokemonDto
import kotlinx.serialization.SerialName

data class PokemonResponse(
    @SerialName("next") val nextUrl: String?,
    @SerialName("results") val results: MutableList<PokemonDto>
) {
}