package com.nicos.network.domain.repositories

import com.nicos.database.data.room_database.entities.PokemonEntity
import com.nicos.network.generic_classes.Resource
import kotlinx.coroutines.flow.Flow

interface PokemonListRepository {
    suspend fun fetchPokemonList(url: String?): Flow<Resource<MutableList<PokemonEntity>>>
    suspend fun savePokemon(pokemonEntityList: MutableList<PokemonEntity>)
    suspend fun offline(): Flow<Resource<MutableList<PokemonEntity>>>
}