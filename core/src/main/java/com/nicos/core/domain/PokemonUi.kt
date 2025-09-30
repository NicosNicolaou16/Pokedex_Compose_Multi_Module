package com.nicos.core.domain

data class PokemonUi(
    val name: String,
    val url: String?,
    var imageUrl: String?,
    var order: Int?,
)
