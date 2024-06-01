package com.example.krypto.ui.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.krypto.ui.detail.models.CoinDetailUiModel
import com.example.krypto.ui.theme.KryptoTheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun CoinDetailItem(
    modifier: Modifier = Modifier,
    model: CoinDetailUiModel,
    onClick: (String) -> Unit = {}
) {
    Column(modifier = modifier.windowInsetsPadding(WindowInsets.statusBars)
        .fillMaxSize().padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
Text(text = model.name)
        Text(text = model.message)
        Text(text = model.description)
    }

}

@Preview
@Composable
private fun CoinDetailItemPreview() {
    KryptoTheme {
        CoinDetailItem(
            model = CoinDetailUiModel(
                name = "Bit Coin",
                description = "",
                message = ""
            )
        )
    }

}
