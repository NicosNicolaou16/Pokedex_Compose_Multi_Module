package com.nicos.database.data.room_database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nicos.core.domain.PokemonDetailsUI
import com.nicos.database.data.mappers.toStatsUi
import com.nicos.database.data.room_database.init_database.MyRoomDatabase
import com.nicos.network.domain.dto.PokemonDetailsDto

@Entity
data class PokemonDetailsEntity(
    @PrimaryKey
    val name: String,
    val weight: Int?
) {
    companion object {
        suspend fun getPokemonDetails(
            pokemonName: String,
            myRoomDatabase: MyRoomDatabase
        ): PokemonDetailsWithStatsEntity? {
            val pokemonDetailsEntity: PokemonDetailsWithStatsEntity? =
                myRoomDatabase.pokemonDetailDao()
                    .getPokemonDetailsWithStatsAndStatsByName(pokemonName)
            return pokemonDetailsEntity
        }
    }
}

fun PokemonDetailsDto.toPokemonDetailsEntity(): PokemonDetailsEntity {
    return PokemonDetailsEntity(
        name = name,
        weight = weight
    )
}