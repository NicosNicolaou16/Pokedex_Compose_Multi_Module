package com.nicos.network.domain.repositories

import com.nicos.database.data.room_database.entities.PokemonDetailsEntity
import com.nicos.database.data.room_database.entities.PokemonEntity
import com.nicos.network.generic_classes.Resource
import kotlinx.coroutines.flow.Flow

interface PokemonDetailsRepository {
    suspend fun fetchPokemonDetails(url: String, name: String): Flow<Resource<PokemonDetailsEntity>>
    suspend fun savePokemonDetails(pokemonDetailsEntity: PokemonDetailsEntity)
    suspend fun offline(name: String): Flow<Resource<PokemonDetailsEntity>>
}