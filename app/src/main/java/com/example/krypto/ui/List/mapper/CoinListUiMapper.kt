package com.example.krypto.ui.List.mapper

import com.example.krypto.domain.models.CoinListModel
import com.example.krypto.ui.List.models.CoinListUiModel
import javax.inject.Inject

class CoinListUiMapper @Inject constructor() {
    fun mapToUiModel(coinsList: List<CoinListModel>): List<CoinListUiModel>{
        return coinsList.map {
            CoinListUiModel(
                id =it.id,
                name = it.name,
                rank = it.rank,
                isActive = it.isActive

            )
        }
    }
}