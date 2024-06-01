package com.example.krypto.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.krypto.domain.usecases.GetCoinDetailUseCase
import com.example.krypto.ui.detail.mapper.CoinDetailUiMapper
import com.example.krypto.ui.detail.models.CoinDetailScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val useCase: GetCoinDetailUseCase,
    private val uiMapper: CoinDetailUiMapper,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val coinId = savedStateHandle.get<String>("coinId")

    private val _uiState = MutableStateFlow(CoinDetailScreenState(isLoading = true))

    val uiState by lazy {
        getDetailData()
        _uiState.asStateFlow()
    }

    private fun getDetailData() {
        viewModelScope.launch {
            runCatching {
                useCase.execute(coinId.orEmpty())
            }.onSuccess { model ->
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        data = uiMapper.mapToUiModel(model)
                    )
                }
            }.onFailure {
                _uiState.update {
                    it.copy(
                        isLoading = false, hasError = true
                    )
                }
            }
        }
    }
}