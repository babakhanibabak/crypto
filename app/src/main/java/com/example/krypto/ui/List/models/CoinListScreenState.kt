package com.example.krypto.ui.List.models

sealed class CoinListScreenState {

    data object Loading : CoinListScreenState()

    data class Success(
        val coinsList: List<CoinListUiModel>
    ) : CoinListScreenState()

    data class Error(
        val errorMessage: String
    ) : CoinListScreenState()

}