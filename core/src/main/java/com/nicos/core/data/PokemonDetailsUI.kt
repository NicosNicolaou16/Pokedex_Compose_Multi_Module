package com.nicos.core.data

data class PokemonDetailsUI(
    val name: String,
    val stats: MutableList<StatsUi>,
    val weight: Int,
)

