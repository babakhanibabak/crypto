package com.example.krypto.ui.Detail.models

import java.lang.Error

data class CoinDetailScreenState(
    val hasError: Boolean = false,
    val isLoading: Boolean = false,
    val data: CoinDetailUiModel? = null,
)
