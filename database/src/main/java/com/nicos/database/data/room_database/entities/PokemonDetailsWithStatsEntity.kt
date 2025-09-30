package com.nicos.database.data.room_database.entities

import androidx.room.Embedded
import androidx.room.Relation

/**
 * One to Many relationship between PokemonDetailsEntity and StatsEntity
 * */
data class PokemonDetailsWithStatsEntity(
    @Embedded val pokemonDetailsEntity: PokemonDetailsEntity,
    @Relation(
        parentColumn = "name",
        entityColumn = "pokemonName"
    )
    val statsEntityList: MutableList<StatsEntity>
)
