package com.crossdevelop.cryptocoincompose.feature.coindetail

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.crossdevelop.cryptocoincompose.feature.AppContainer
import com.crossdevelop.cryptocoincompose.feature.CryptoCoinDestinations
import timber.log.Timber


@Composable
fun CoinDetailRoute(
    appContainer: AppContainer,
    scaffoldState: ScaffoldState = rememberScaffoldState()
) {
    CoinDetailScreen(appContainer)
}

fun NavHostController.navigateCoinListToCoinDetail(coinId: String) {
    val route = "${CryptoCoinDestinations.DETAIL_ROUTE}/$coinId"
    navigate(route) {
        Timber.d("navigating to -> $route")
        launchSingleTop = true
    }
}