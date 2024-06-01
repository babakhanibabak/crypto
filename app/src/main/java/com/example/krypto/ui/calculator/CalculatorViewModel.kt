package com.example.krypto.ui.calculator

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CalculatorViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(CalculatorScreenUiState())

    val uiState: StateFlow<CalculatorScreenUiState> = _uiState.asStateFlow()

    fun setNumber(number: Int) {
        if (_uiState.value.operator == null)  {
            _uiState.update { it.copy(firstNumber = number, result = number) }
        } else {
            _uiState.update { it.copy(secondNumber = number, result = number) }
        }
    }

    fun setOperator(operator: CalculatorOperator) {
        _uiState.update { it.copy(operator = operator) }
    }

    fun getResult() {

    }
}