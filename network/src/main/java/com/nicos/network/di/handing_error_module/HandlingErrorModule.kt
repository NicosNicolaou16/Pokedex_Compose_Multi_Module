package com.nicos.network.di.handing_error_module

import android.content.Context
import com.nicos.network.generic_classes.HandlingError
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object HandlingErrorModule {

    @Singleton
    @Provides
    fun getHandleError(@ApplicationContext context: Context) = HandlingError(context)
}