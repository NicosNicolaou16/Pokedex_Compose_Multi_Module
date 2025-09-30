package com.nicos.core.domain

data class PokemonDetailsUI(
    val name: String,
    val stats: MutableList<StatsUi>,
    val weight: Int,
)

