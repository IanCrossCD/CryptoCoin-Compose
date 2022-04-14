package com.crossdevelop.cryptocoincompose.feature.coindashboard

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable


@Composable
fun CoinDashboardRoute(
    scaffoldState: ScaffoldState = rememberScaffoldState()
) {
    CoinDashboardScreen()
}