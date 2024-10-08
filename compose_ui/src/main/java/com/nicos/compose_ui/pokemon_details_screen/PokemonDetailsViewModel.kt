package com.nicos.compose_ui.pokemon_details_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicos.database.data.models.pokemon_details_data_model.PokemonDetailsDataModel
import com.nicos.network.domain.repositories.PokemonDetailsRepository
import com.nicos.network.generic_classes.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
    private val pokemonDetailsRepository: PokemonDetailsRepository
) : ViewModel() {

    private val _pokemonDetailsState =
        MutableStateFlow<PokemonDetailsState>(PokemonDetailsState(pokemonDetailsDataModelList = emptyList<PokemonDetailsDataModel>().toMutableList()))
    val pokemonDetailsState: MutableStateFlow<PokemonDetailsState> = _pokemonDetailsState

    fun requestToFetchPokemonDetails(
        url: String,
        imageUrl: String,
        name: String,
    ) = viewModelScope.launch(Dispatchers.IO) {
        _pokemonDetailsState.value = _pokemonDetailsState.value.copy(isLoading = true)
        pokemonDetailsRepository.fetchPokemonDetails(url, name).let { resource ->
            when (resource) {
                is Resource.Success -> {
                    _pokemonDetailsState.value =
                        _pokemonDetailsState.value.copy(
                            isLoading = false,
                            pokemonDetailsDataModelList = PokemonDetailsDataModel.createPokemonDetailsDataModel(
                                resource.data,
                                imageUrl = imageUrl
                            )
                        )
                }

                is Resource.Error -> {
                    _pokemonDetailsState.value =
                        _pokemonDetailsState.value.copy(
                            isLoading = false,
                            error = resource.message
                        )
                }
            }
        }
    }

    fun offline(imageUrl: String, name: String) = viewModelScope.launch(Dispatchers.IO) {
        _pokemonDetailsState.value = _pokemonDetailsState.value.copy(isLoading = true)
        pokemonDetailsRepository.offline(name).let { resource ->
            when (resource) {
                is Resource.Success -> {
                    _pokemonDetailsState.value =
                        _pokemonDetailsState.value.copy(
                            isLoading = false,
                            pokemonDetailsDataModelList = PokemonDetailsDataModel.createPokemonDetailsDataModel(
                                resource.data,
                                imageUrl = imageUrl
                            )
                        )
                }

                is Resource.Error -> {
                    _pokemonDetailsState.value =
                        _pokemonDetailsState.value.copy(
                            isLoading = false,
                            error = resource.message
                        )
                }
            }
        }
    }
}