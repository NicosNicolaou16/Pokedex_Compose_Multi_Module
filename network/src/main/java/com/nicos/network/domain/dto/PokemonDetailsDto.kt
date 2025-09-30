package com.nicos.network.domain.dto

import com.google.gson.annotations.SerializedName

data class PokemonDetailsDto(
    val name: String,
    @SerializedName("stats") var statsEntity: MutableList<StatsDto>?,
    val weight: Int?
)
