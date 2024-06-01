package com.example.krypto.ui.calculator

data class CalculatorScreenUiState(
    val firstNumber: Int = 0,
    val secondNumber: Int = 0,
    val operator: CalculatorOperator? = null,
    val result: Int = 0,
)

sealed interface CalculatorOperator {
    data object Plus : CalculatorOperator
    data object Minus : CalculatorOperator
    data object Divide : CalculatorOperator
    data object Multiply : CalculatorOperator
}