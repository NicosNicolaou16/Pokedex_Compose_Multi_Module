package com.nicos.core.domain.repositories

import com.nicos.core.data.PokemonUi
import com.nicos.core.utilities.Resource
import kotlinx.coroutines.flow.Flow

interface PokemonListRepository {
    suspend fun fetchPokemonList(url: String?): Flow<Resource<MutableList<PokemonUi>>>
    suspend fun offline(): Flow<Resource<MutableList<PokemonUi>>>
}