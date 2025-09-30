package com.nicos.database.data.room_database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nicos.network.domain.dto.PokemonDetailsDto

@Entity
data class PokemonDetailsEntity(
    @PrimaryKey
    val name: String,
    val weight: Int?
)

fun PokemonDetailsDto.toPokemonDetailsEntity(): PokemonDetailsEntity {
    return PokemonDetailsEntity(
        name = name,
        weight = weight
    )
}