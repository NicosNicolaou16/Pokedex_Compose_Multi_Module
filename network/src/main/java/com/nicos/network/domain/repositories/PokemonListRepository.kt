package com.nicos.network.domain.repositories

import com.nicos.core.domain.PokemonUi
import com.nicos.network.domain.dto.PokemonDto
import com.nicos.network.generic_classes.Resource
import kotlinx.coroutines.flow.Flow

interface PokemonListRepository {
    suspend fun fetchPokemonList(url: String?): Flow<Resource<MutableList<PokemonUi>>>
    suspend fun savePokemon(pokemonDto: MutableList<PokemonDto>)
    suspend fun offline(): Flow<Resource<MutableList<PokemonUi>>>
}