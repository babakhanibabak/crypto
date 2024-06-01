package com.example.krypto.data.repositories

import com.example.krypto.data.dataSource.api.CoinApiService
import com.example.krypto.data.dataSource.api.dto.mapToDomainModel
import com.example.krypto.domain.models.CoinDetailModel
import com.example.krypto.domain.models.CoinListModel
import com.example.krypto.domain.repositories.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val apiService: CoinApiService
) : CoinRepository {
    override suspend fun getCoinList(): List<CoinListModel> {
        return apiService.getCoinList().map {
            it.mapToDomainModel()
        }
    }

    override suspend fun getCoinDetail(coinId: String): CoinDetailModel {
        return mapToDomainModel(apiService.getCoinDetail(coinId))
    }
}