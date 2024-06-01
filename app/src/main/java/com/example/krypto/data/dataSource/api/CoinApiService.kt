package com.example.krypto.data.dataSource.api

import com.example.krypto.data.dataSource.api.dto.CoinDetailDto
import com.example.krypto.data.dataSource.api.dto.CoinListDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinApiService {
    @GET("/v1/coins")
    suspend fun getCoinList():List<CoinListDto>

    @GET("/v1/coins/{coin_id}")
    suspend fun getCoinDetail(@Path("coin_id") coinId:String):CoinDetailDto
}