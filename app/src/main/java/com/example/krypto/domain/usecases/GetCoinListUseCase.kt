package com.example.krypto.domain.usecases

import com.example.krypto.domain.models.CoinListModel
import com.example.krypto.domain.repositories.CoinRepository
import javax.inject.Inject

class GetCoinListUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    suspend fun execute():List<CoinListModel>{
        return repository.getCoinList()
    }
}