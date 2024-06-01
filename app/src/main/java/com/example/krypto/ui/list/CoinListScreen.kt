package com.example.krypto.ui.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.krypto.ui.list.components.CoinListItem
import com.example.krypto.ui.list.models.CoinListScreenState
import com.example.krypto.ui.list.models.CoinListUiModel

@Composable
fun CoinListScreen(
    viewModel: CoinListViewModel = hiltViewModel(),
    onItemClick: (String) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    CoinListScreenContent(uiState = uiState, onItemClick = onItemClick)
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun CoinListScreenContent(
    uiState: CoinListScreenState,
    onItemClick: (String) -> Unit
) {
    Scaffold(modifier = Modifier.windowInsetsPadding(WindowInsets.statusBars),
        topBar = { TopAppBar(title = { Text(text = "CoinsList") }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .consumeWindowInsets(padding)
                .imePadding(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (uiState) {
                is CoinListScreenState.Loading -> Loading()


                is CoinListScreenState.Success -> {
                    ShowDataList(coinsList = uiState.coinsList,onItemClick=onItemClick) 
                }
                is CoinListScreenState.Error -> {
                    ShowError(message = uiState.errorMessage)
                }
            }
        }
    }
}

@Composable
private fun Loading() {
    CircularProgressIndicator(
        modifier = Modifier.size(32.dp)
    )
}

@Composable
private fun ShowDataList(
    coinsList: List<CoinListUiModel>,
    onItemClick: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(coinsList) {
            CoinListItem(model = it, onClick = onItemClick)
        }
    }
}

@Composable
private fun ShowError(
    message: String
) {
    Text(text = message,
        color = Color.Red,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
        )
}