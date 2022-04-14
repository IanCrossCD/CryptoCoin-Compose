package com.crossdevelop.cryptocoincompose.feature.coindetail

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable


@Composable
fun CoinDetailRoute(
    coinId : String,
    scaffoldState: ScaffoldState = rememberScaffoldState()
) {
    CoinDetailScreen(coinId = coinId)
}