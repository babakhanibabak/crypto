package com.example.krypto.domain.repositories

import com.example.krypto.domain.models.CoinDetailModel
import com.example.krypto.domain.models.CoinListModel

interface CoinRepository {
    suspend fun getCoinList(): List<CoinListModel>

    suspend fun getCoinDetail(coinId:String):CoinDetailModel
}