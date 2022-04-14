package com.crossdevelop.cryptocoincompose.feature

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.crossdevelop.cryptocoincompose.feature.coindashboard.CoinDashboardRoute
import com.crossdevelop.cryptocoincompose.feature.coindetail.CoinDetailRoute


@Composable
fun CryptoCoinNavGraph(
    modifier: Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = CryptoCoinDestinations.DASHBOARD_ROUTE
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(route = CryptoCoinDestinations.DASHBOARD_ROUTE) {
            CoinDashboardRoute()
        }
        composable(
            route = CryptoCoinDestinations.DETAIL_ROUTE,
            arguments = listOf(navArgument(CryptoCoinNavArgs.COIN_ID) { type = NavType.StringType })
        ) { backStackEntry ->
            CoinDetailRoute(coinId = backStackEntry.arguments?.getString(CryptoCoinNavArgs.COIN_ID)!!)
        }
    }
}