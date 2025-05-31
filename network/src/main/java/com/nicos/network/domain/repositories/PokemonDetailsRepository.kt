package com.nicos.network.domain.repositories

import com.nicos.database.data.room_database.entities.PokemonDetailsEntity
import com.nicos.database.data.room_database.entities.PokemonEntity
import com.nicos.network.generic_classes.Resource

interface PokemonDetailsRepository {
    suspend fun fetchPokemonDetails(url: String, name: String): Resource<PokemonDetailsEntity>
    suspend fun savePokemonDetails(pokemonDetailsEntity: PokemonDetailsEntity)
    suspend fun offline(name: String): Resource<PokemonDetailsEntity>
}