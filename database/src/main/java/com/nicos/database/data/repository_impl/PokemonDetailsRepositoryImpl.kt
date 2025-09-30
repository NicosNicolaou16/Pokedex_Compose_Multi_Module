package com.nicos.database.data.repository_impl

import com.nicos.core.domain.PokemonDetailsUI
import com.nicos.database.data.mappers.toPokemonDetailsUI
import com.nicos.database.data.room_database.entities.PokemonDetailsEntity
import com.nicos.database.data.room_database.entities.PokemonDetailsWithStatsEntity
import com.nicos.database.data.room_database.entities.toPokemonDetailsEntity
import com.nicos.database.data.room_database.entities.toStatsEntity
import com.nicos.database.data.room_database.init_database.MyRoomDatabase
import com.nicos.network.domain.dto.PokemonDetailsDto
import com.nicos.network.domain.remote.PokemonService
import com.nicos.network.domain.repositories.PokemonDetailsRepository
import com.nicos.network.generic_classes.HandlingError
import com.nicos.network.generic_classes.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PokemonDetailsRepositoryImpl @Inject constructor(
    private val myRoomDatabase: MyRoomDatabase,
    private val pokemonService: PokemonService,
    private val handlingError: HandlingError,
) : PokemonDetailsRepository {

    override suspend fun fetchPokemonDetails(
        url: String,
        name: String
    ): Flow<Resource<PokemonDetailsUI>> {
        return flow {
            try {
                val pokemonDetails: PokemonDetailsDto = pokemonService.getPokemonDetails(url = url)
                savePokemonDetails(pokemonDetailsDto = pokemonDetails)
                val pokemonDetailsEntity: PokemonDetailsWithStatsEntity? =
                    myRoomDatabase.pokemonDetailDao()
                        .getPokemonDetailsWithStatsAndStatsByName(name)
                emit(
                    Resource.Success(
                        data = pokemonDetailsEntity?.toPokemonDetailsUI()
                    )
                )
            } catch (e: Exception) {
                emit(Resource.Error(message = handlingError.handleErrorMessage(e)))
            }
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun savePokemonDetails(pokemonDetailsDto: PokemonDetailsDto) {
        myRoomDatabase.statsDao().deleteByPokemonName(name = pokemonDetailsDto.name)
        myRoomDatabase.pokemonDetailDao()
            .insertOrReplaceObject(data = pokemonDetailsDto.toPokemonDetailsEntity())
        pokemonDetailsDto.statsEntity?.forEach { statsEntity ->
            if (statsEntity.stat != null) {
                myRoomDatabase.statsDao().insertOrReplaceObject(
                    statsEntity.toStatsEntity(
                        pokemonName = pokemonDetailsDto.name,
                        statDto = statsEntity.stat
                    )
                )
            }
        }
    }

    override suspend fun offline(name: String): Flow<Resource<PokemonDetailsUI>> {
        return flow {
            try {
                val pokemonDetailsEntity: PokemonDetailsWithStatsEntity? =
                    myRoomDatabase.pokemonDetailDao()
                        .getPokemonDetailsWithStatsAndStatsByName(name)
                emit(
                    Resource.Success(
                        data = pokemonDetailsEntity?.toPokemonDetailsUI()
                    )
                )
            } catch (e: Exception) {
                emit(Resource.Error(message = handlingError.handleErrorMessage(e)))
            }
        }.flowOn(Dispatchers.IO)
    }
}