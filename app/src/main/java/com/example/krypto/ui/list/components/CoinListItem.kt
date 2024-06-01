package com.example.krypto.ui.list.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.krypto.ui.list.models.CoinListUiModel
import com.example.krypto.ui.theme.KryptoTheme

@Composable
fun CoinListItem(
    modifier: Modifier=Modifier,
    model: CoinListUiModel,
    onClick:(String)->Unit={}
){
Card(modifier= modifier
    .fillMaxWidth()
    .border(
        width = 2.dp,
        color = if (model.isActive) Color.Green else Color.Red,
        shape = RoundedCornerShape(4.dp)
    )
    .clickable { onClick(model.id) },
   ) {
    Text( text =model.name)
}
}

@Preview
@Composable
fun CoinListItemActivePreview() {
    KryptoTheme {
        CoinListItem(
            modifier = Modifier.padding(16.dp),
            model = CoinListUiModel("id", "BitCoin", 1, isActive = true)
        )
    }
}

@Preview
@Composable
fun CoinListItemInActivePreview() {
    KryptoTheme {
        CoinListItem(
            modifier = Modifier.padding(16.dp),
            model = CoinListUiModel("id", "BitCoin", 1, isActive = false)
        )
    }
}