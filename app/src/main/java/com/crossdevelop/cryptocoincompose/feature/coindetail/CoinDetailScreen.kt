package com.crossdevelop.cryptocoincompose.feature.coindetail

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.crossdevelop.cryptocoincompose.common.ui.theme.CryptoCoinTheme
import com.crossdevelop.cryptocoincompose.core.ui.InsetAwareTopAppBar
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues


@Composable
fun CoinDetailScreen(coinId: String) {

    val viewModel: CoinDetailViewModel = hiltViewModel()

    val navigationBarPaddingValues = rememberInsetsPaddingValues(insets = LocalWindowInsets.current.navigationBars)

    val coroutineScope = rememberCoroutineScope()

    val coinDetail by viewModel.coinDetail.observeAsState()

    Column {

        InsetAwareTopAppBar(
            title = "DETAIL:${coinDetail?.symbol}",
        )

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CryptoCoinTheme {
        CoinDetailScreen("Preview")
    }
}