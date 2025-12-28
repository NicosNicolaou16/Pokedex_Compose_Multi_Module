package com.nicos.navigation.navigation.screen_routes

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
object PokemonList : NavKey

@Serializable
data class PokemonDetails(
    val url: String,
    val imageUrl: String,
    val name: String,
): NavKey