package com.nicos.core.domain.repositories

import com.nicos.core.data.PokemonDetailsUI
import com.nicos.core.utilities.Resource
import kotlinx.coroutines.flow.Flow

interface PokemonDetailsRepository {
    suspend fun fetchPokemonDetails(url: String, name: String): Flow<Resource<PokemonDetailsUI>>
    suspend fun offline(name: String): Flow<Resource<PokemonDetailsUI>>
}