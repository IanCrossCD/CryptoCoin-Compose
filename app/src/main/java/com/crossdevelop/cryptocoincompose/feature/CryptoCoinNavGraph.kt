package com.crossdevelop.cryptocoincompose.feature

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.crossdevelop.cryptocoincompose.feature.dashboard.DashboardRoute


@Composable
fun CryptoCoinNavGraph(
    isExpandedScreen: Boolean,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = CryptoCoinDestinations.DASHBOARD_ROUTE
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(CryptoCoinDestinations.DASHBOARD_ROUTE) {
//            val homeViewModel: HomeViewModel = viewModel(
//                factory = HomeViewModel.provideFactory(appContainer.postsRepository)
//            )

            DashboardRoute(isExpandedScreen = isExpandedScreen)
        }
        composable(CryptoCoinDestinations.DETAIL_ROUTE) {
//            val interestsViewModel: InterestsViewModel = viewModel(
//                factory = InterestsViewModel.provideFactory(appContainer.interestsRepository)
//            )

        }
    }
}