package com.nicos.network.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StatsDto(
    @SerialName("base_stat") val baseStat: Int?,
    val stat: StatDto?,
    val pokemonName: String?,
) {
}