package com.nicos.database.data.mappers

import com.nicos.core.domain.StatsUi
import com.nicos.database.data.room_database.entities.StatsEntity

fun StatsEntity.toStatsUi(): StatsUi {
    return StatsUi(
        baseStat = this.baseStat,
        statName = this.statName
    )
}

fun StatsUi.toStatsEntity(pokemonName: String): StatsEntity {
    return StatsEntity(
        baseStat = this.baseStat,
        statName = this.statName,
        pokemonName = pokemonName
    )
}