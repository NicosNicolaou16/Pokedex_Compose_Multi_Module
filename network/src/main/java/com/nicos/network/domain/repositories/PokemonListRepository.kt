package com.nicos.network.domain.repositories

import com.nicos.database.data.room_database.entities.PokemonEntity
import com.nicos.network.generic_classes.Resource

interface PokemonListRepository {
    suspend fun fetchPokemonList(url: String?): Resource<MutableList<PokemonEntity>>
    suspend fun savePokemon(pokemonEntityList: MutableList<PokemonEntity>)
    suspend fun offline(): Resource<MutableList<PokemonEntity>>
}