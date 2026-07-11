package com.nicos.database.data.room_database.entities

import androidx.room3.Entity
import androidx.room3.PrimaryKey
import com.nicos.network.data.dto.PokemonDto

@Entity
data class PokemonEntity(
    @PrimaryKey
    val name: String,
    val url: String?,
    var imageUrl: String?,
    var order: Int?,
)

fun PokemonDto.toPokemonEntity(): PokemonEntity {
    return PokemonEntity(
        name = name,
        url = url,
        imageUrl = imageUrl,
        order = order
    )
}

