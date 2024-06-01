package com.example.krypto.ui.detail.models

data class CoinDetailScreenState(
    val hasError: Boolean = false,
    val isLoading: Boolean = false,
    val data: CoinDetailUiModel? = null,
)
