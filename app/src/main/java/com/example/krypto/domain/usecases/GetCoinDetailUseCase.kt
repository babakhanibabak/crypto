package com.example.krypto.domain.usecases

import android.adservices.adid.AdId
import com.example.krypto.domain.models.CoinDetailModel
import com.example.krypto.domain.repositories.CoinRepository
import javax.inject.Inject

class GetCoinDetailUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    suspend fun execute(coinId: String):CoinDetailModel{
        return repository.getCoinDetail(coinId)
    }
}