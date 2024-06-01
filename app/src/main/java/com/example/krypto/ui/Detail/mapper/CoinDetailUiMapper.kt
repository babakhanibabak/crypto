package com.example.krypto.ui.Detail.mapper

import com.example.krypto.domain.models.CoinDetailModel
import com.example.krypto.ui.Detail.models.CoinDetailUiModel
import javax.inject.Inject

class CoinDetailUiMapper @Inject constructor() {
    fun mapToUiModel(model: CoinDetailModel):CoinDetailUiModel{
        return CoinDetailUiModel(
            name = model.name,
            message = "",
            description = ""

        )
    }
}