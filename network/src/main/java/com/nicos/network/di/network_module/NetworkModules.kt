package com.nicos.network.di.network_module

import com.nicos.network.domain.remote.init_network.MyNetworkManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModules {


    @Provides
    @Singleton
    fun requestBuilder(): Retrofit = MyNetworkManager.initNetworkManager()
}