package com.nicos.network.di.network.services

import com.nicos.network.domain.remote.PokemonService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PokemonModule {

    @Provides
    @Singleton
    fun getPokemonList(retrofit: Retrofit): PokemonService {
        return retrofit.create(PokemonService::class.java)
    }
}