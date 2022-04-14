package com.crossdevelop.cryptocoincompose.feature

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController


/**
 * Destinations used in the [CryptoCoinApp].
 */
object CryptoCoinDestinations {
    const val DASHBOARD_ROUTE = "dashboard"
    const val DETAIL_ROUTE = "detail/{coinId}"
}

object CryptoCoinNavArgs {
    const val COIN_ID = "coinId"
}

/**
 * Models the navigation actions in the app.
 */
class CryptoCoinNavigationActions(navController: NavHostController) {
    val navigateToDashboard: () -> Unit = {
        navController.navigate(CryptoCoinDestinations.DASHBOARD_ROUTE) {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }
    }

    lateinit var coinId : String
    val navigateToDetail: () -> Unit = {
        navController.navigate("${CryptoCoinDestinations.DETAIL_ROUTE}/$coinId") {
            launchSingleTop = true
            restoreState = true
        }
    }
}
