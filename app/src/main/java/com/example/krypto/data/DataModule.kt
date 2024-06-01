package com.example.krypto.data

import com.example.krypto.data.repositories.CoinRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.example.krypto.domain.repositories.CoinRepository

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    @Singleton
    fun provideCoinRepository(impl: CoinRepositoryImpl): CoinRepository
}