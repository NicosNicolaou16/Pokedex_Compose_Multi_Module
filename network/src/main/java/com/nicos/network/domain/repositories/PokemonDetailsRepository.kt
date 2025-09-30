package com.nicos.network.domain.repositories

import com.nicos.core.domain.PokemonDetailsUI
import com.nicos.network.domain.dto.PokemonDetailsDto
import com.nicos.network.generic_classes.Resource
import kotlinx.coroutines.flow.Flow

interface PokemonDetailsRepository {
    suspend fun fetchPokemonDetails(url: String, name: String): Flow<Resource<PokemonDetailsUI>>
    suspend fun savePokemonDetails(pokemonDetailsDto: PokemonDetailsDto)
    suspend fun offline(name: String): Flow<Resource<PokemonDetailsUI>>
}