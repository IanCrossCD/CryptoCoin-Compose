package com.crossdevelop.cryptocoincompose.feature

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.crossdevelop.cryptocoincompose.feature.coindashboard.CoinDashboardRoute
import com.crossdevelop.cryptocoincompose.feature.coindetail.CoinDetailRoute
import timber.log.Timber


/**
 * Destinations used in the [CryptoCoinApp].
 */
object CryptoCoinDestinations {
    const val DASHBOARD_ROUTE = "dashboard"
    const val DETAIL_ROUTE = "detail"
}

object CryptoCoinNavArgs {
    const val COIN_ID = "coinId"
}

@Composable
fun CryptoCoinNavGraph(
    modifier: Modifier,
    appContainer: AppContainer,
    startDestination: String = CryptoCoinDestinations.DASHBOARD_ROUTE
) {
    NavHost(
        navController = appContainer.navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(CryptoCoinDestinations.DASHBOARD_ROUTE) {
            CoinDashboardRoute(appContainer)
        }
        composable(
            "${CryptoCoinDestinations.DETAIL_ROUTE}/{${CryptoCoinNavArgs.COIN_ID}}",
            arguments = listOf(navArgument(CryptoCoinNavArgs.COIN_ID) { type = NavType.StringType })
        ) { backStackEntry ->
            Timber.d("Nav arg is :${backStackEntry.arguments?.getString(CryptoCoinNavArgs.COIN_ID)}")
            CoinDetailRoute(appContainer)
        }
    }
}