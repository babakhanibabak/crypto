package com.example.krypto.data.dataSource.api.dto

import com.example.krypto.domain.models.CoinListModel
import com.google.gson.annotations.SerializedName

data class CoinListDto(
    @SerializedName("id")
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Int,
    @SerializedName("is_new")
    val isNew: Boolean,
    @SerializedName("is_active")
    val isActive: Boolean,
    val type: String,
)


fun CoinListDto.mapToDomainModel() = CoinListModel(
    id = id,
    name = name,
    symbol = symbol,
    rank = rank,
    isNew = isNew,
    isActive = isActive,
    type = type,
)