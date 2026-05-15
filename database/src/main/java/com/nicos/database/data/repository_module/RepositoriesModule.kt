package com.nicos.database.data.repository_module

import com.nicos.database.data.repository_impl.PokemonDetailsRepositoryImpl
import com.nicos.database.data.repository_impl.PokemonListRepositoryImpl
import com.nicos.database.data.room_database.init_database.MyRoomDatabase
import com.nicos.network.data.remote.PokemonService
import com.nicos.network.domain.repositories.PokemonDetailsRepository
import com.nicos.network.domain.repositories.PokemonListRepository
import com.nicos.network.generic_classes.HandlingError
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object RepositoriesModule {

    @Provides
    fun getPokemonListRepository(
        myRoomDatabase: MyRoomDatabase,
        pokemonService: PokemonService,
        handlingError: HandlingError
    ): PokemonListRepository {
        return PokemonListRepositoryImpl(
            myRoomDatabase,
            pokemonService,
            handlingError
        )
    }

    @Provides
    fun getPokemonDetailsRepository(
        myRoomDatabase: MyRoomDatabase,
        pokemonService: PokemonService,
        handlingError: HandlingError
    ): PokemonDetailsRepository {
        return PokemonDetailsRepositoryImpl(
            myRoomDatabase,
            pokemonService,
            handlingError
        )
    }
}