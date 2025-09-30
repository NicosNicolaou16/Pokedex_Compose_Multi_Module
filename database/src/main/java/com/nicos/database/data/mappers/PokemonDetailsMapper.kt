package com.nicos.database.data.mappers

import com.nicos.core.domain.PokemonDetailsUI
import com.nicos.database.data.room_database.entities.PokemonDetailsEntity
import com.nicos.database.data.room_database.entities.PokemonDetailsWithStatsEntity

fun PokemonDetailsWithStatsEntity.toPokemonDetailsUi(): PokemonDetailsUI {
    return PokemonDetailsUI(
        name = this.pokemonDetailsEntity.name,
        stats = this.statsEntityList.map { it.toStatsUi() }.toMutableList(),
        weight = this.pokemonDetailsEntity.weight ?: 0,
    )
}

fun PokemonDetailsUI.toPokemonDetailsEntity(): PokemonDetailsWithStatsEntity {
    return PokemonDetailsWithStatsEntity(
        pokemonDetailsEntity = PokemonDetailsEntity(
            name = this.name,
            weight = this.weight
        ),
        statsEntityList = this.stats.map { it.toStatsEntity(this.name) }.toMutableList()
    )
}

fun PokemonDetailsWithStatsEntity.toPokemonDetailsUI(): PokemonDetailsUI {
    return PokemonDetailsUI(
        name = pokemonDetailsEntity.name,
        stats = this.statsEntityList.map { it.toStatsUi() }.toMutableList(),
        weight = pokemonDetailsEntity.weight ?: 0
    )
}
