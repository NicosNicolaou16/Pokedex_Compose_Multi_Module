package com.nicos.core.domain.pokemon_details_data_model

import com.nicos.core.domain.PokemonDetailsUI
import com.nicos.core.domain.StatsUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

data class PokemonDetailsDataModel(
    val imageUrl: String? = null,
    val name: String? = null,
    val weight: Int? = null,
    val statsEntity: StatsUi? = null,
    val maxValue: Int? = 0,
    val pokemonDetailsViewTypes: PokemonDetailsViewTypes,
) {
    companion object {
        fun createPokemonDetailsDataModel(
            pokemonDetailsWithStatsEntity: PokemonDetailsUI?,
            imageUrl: String?
        ) = flow {
            emit(mutableListOf<PokemonDetailsDataModel>().apply {
                add(
                    PokemonDetailsDataModel(
                        imageUrl = imageUrl,
                        name = pokemonDetailsWithStatsEntity?.name ?: "",
                        weight = pokemonDetailsWithStatsEntity?.weight ?: 0,
                        pokemonDetailsViewTypes = PokemonDetailsViewTypes.IMAGE_AND_NAME_VIEW_TYPE
                    )
                )

                val maxValue: Int =
                    pokemonDetailsWithStatsEntity?.stats?.maxOfOrNull { it.baseStat ?: 0 }
                        ?: 0
                pokemonDetailsWithStatsEntity?.stats?.forEach { statsEntity ->
                    add(
                        PokemonDetailsDataModel(
                            statsEntity = statsEntity,
                            maxValue = maxValue,
                            pokemonDetailsViewTypes = PokemonDetailsViewTypes.STAT_VIEW_TYPE
                        )
                    )
                }
            })
        }.flowOn(Dispatchers.IO)
    }
}

enum class PokemonDetailsViewTypes {
    IMAGE_AND_NAME_VIEW_TYPE,
    STAT_VIEW_TYPE,
}
