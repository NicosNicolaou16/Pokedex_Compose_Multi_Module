package com.nicos.navigation.navigation.screen_routes

import kotlinx.serialization.Serializable

@Serializable
object PokemonList

@Serializable
data class PokemonDetails(
    val url: String,
    val imageUrl: String,
    val name: String,
)