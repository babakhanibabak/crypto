package com.example.krypto.ui.List

import androidx.lifecycle.ViewModel
import com.example.krypto.domain.usecases.GetCoinListUseCase
import com.example.krypto.ui.List.models.CoinListScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.example.krypto.ui.List.mapper.CoinListUiMapper

class CoinListViewModel @Inject constructor(
    private val useCase: GetCoinListUseCase,
    private val uiMapper: CoinListUiMapper
) : ViewModel() {
    private val _uiState: MutableStateFlow<CoinListScreenState> =
        MutableStateFlow(CoinListScreenState.Loading)
    val uiState by lazy {
        loadData()
        _uiState.asStateFlow()
    }

    fun loadData() {
        viewModelScope.launch {
            runCatching { useCase.execute() }.onFailure {
                _uiState.value = CoinListScreenState.Error("خطایی رخ داده ")
            }.onSuccess {
                _uiState.value = CoinListScreenState.Success(uiMapper.mapToUiModel(it))
            }
        }

    }

}