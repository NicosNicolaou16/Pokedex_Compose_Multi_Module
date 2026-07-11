package com.nicos.database.data.room_database.entities

import androidx.room3.Entity
import androidx.room3.PrimaryKey
import com.nicos.network.data.dto.PokemonDetailsDto

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