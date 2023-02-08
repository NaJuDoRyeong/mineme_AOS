package com.example.common.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.common.domain.usecase.DataStoreUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataStoreModule {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
        name = DataStoreUseCase.DATA_STORE_NAME
    )



    @Singleton
    @Provides
    fun providePreferencesDataStore(@ApplicationContext context: Context) =
        DataStoreUseCase(context.dataStore)

}