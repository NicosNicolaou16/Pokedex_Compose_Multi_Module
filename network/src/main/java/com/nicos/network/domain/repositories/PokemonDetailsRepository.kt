package com.nicos.network.domain.repositories

import com.nicos.database.data.room_database.entities.PokemonDetailsEntity
import com.nicos.database.data.room_database.init_database.MyRoomDatabase
import com.nicos.network.domain.remote.PokemonService
import com.nicos.network.generic_classes.HandlingError
import com.nicos.network.generic_classes.Resource
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class PokemonDetailsRepository @Inject constructor(
    private val myRoomDatabase: MyRoomDatabase,
    private val pokemonService: PokemonService,
    private val handlingError: HandlingError,
) {

    suspend fun fetchPokemonDetails(url: String, name: String): Resource<PokemonDetailsEntity> {
        return try {
            val pokemonDetailsEntity = pokemonService.getPokemonDetails(url = url)
            savePokemonDetails(pokemonDetailsEntity = pokemonDetailsEntity)

            Resource.Success(data = myRoomDatabase.pokemonDetailDao().getPokemonInfoByName(name))
        } catch (e: Exception) {
            Resource.Error(message = handlingError.handleErrorMessage(e))
        }
    }

    private suspend fun savePokemonDetails(pokemonDetailsEntity: PokemonDetailsEntity) =
        PokemonDetailsEntity.savePokemonDetails(
            pokemonDetailsEntity = pokemonDetailsEntity,
            myRoomDatabase = myRoomDatabase
        ).collect()

    suspend fun offline(name: String): Resource<PokemonDetailsEntity> {
        return try {
            Resource.Success(data = myRoomDatabase.pokemonDetailDao().getPokemonInfoByName(name))
        } catch (e: Exception) {
            Resource.Error(message = handlingError.handleErrorMessage(e))
        }
    }
}