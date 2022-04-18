package com.crossdevelop.cryptocoincompose.feature.coindashboard

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.crossdevelop.cryptocoincompose.feature.AppContainer


@Composable
fun CoinDashboardRoute(
    appContainer: AppContainer,
    scaffoldState: ScaffoldState = rememberScaffoldState()) {
    CoinDashboardScreen(appContainer)
}