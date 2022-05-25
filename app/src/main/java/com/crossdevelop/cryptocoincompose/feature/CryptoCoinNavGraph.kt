package com.crossdevelop.cryptocoincompose.feature

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.crossdevelop.cryptocoincompose.feature.coindashboard.CoinDashboardRoute
import com.crossdevelop.cryptocoincompose.feature.coindetail.CoinDetailRoute
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
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

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CryptoCoinNavGraph(
    modifier: Modifier,
    appContainer: AppContainer,
    startDestination: String = CryptoCoinDestinations.DASHBOARD_ROUTE
) {
    AnimatedNavHost(
        navController = appContainer.navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(route = CryptoCoinDestinations.DASHBOARD_ROUTE,
//            enterTransition = {
//                slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(700))
//            },
//            exitTransition = {
//                slideOutOfContainer(AnimatedContentScope.SlideDirection.Down, animationSpec = tween(700))
//            },
//            popEnterTransition = {
//                slideIntoContainer(AnimatedContentScope.SlideDirection.Up, animationSpec = tween(700))
//            },
//            popExitTransition = {
//                slideOutOfContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(700))
//            }
        ) {
            CoinDashboardRoute(appContainer)
        }
        composable(
            route = "${CryptoCoinDestinations.DETAIL_ROUTE}/{${CryptoCoinNavArgs.COIN_ID}}",
            arguments = listOf(navArgument(CryptoCoinNavArgs.COIN_ID) { type = NavType.StringType }),
//            enterTransition = {
//                slideInHorizontally(initialOffsetX = { 1000 })
//                slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(700))
//            },
//            exitTransition = {
//                slideOutOfContainer(AnimatedContentScope.SlideDirection.Down, animationSpec = tween(700))
//            },
//            popEnterTransition = {
//                slideIntoContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(700))
//            },
//            popExitTransition = {
//                slideOutOfContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(700))
//            }
        ) { backStackEntry ->
            Timber.d("Nav arg is :${backStackEntry.arguments?.getString(CryptoCoinNavArgs.COIN_ID)}")
            CoinDetailRoute(appContainer)
        }
    }
}