package com.crossdevelop.cryptocoincompose.feature

import androidx.compose.foundation.background
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.crossdevelop.cryptocoincompose.common.utils.WindowSize
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun CryptoCoinApp(
//    appContainer: AppContainer,
    windowSize: WindowSize
) {

    Surface(modifier = Modifier.background(MaterialTheme.colors.background)) {

        val systemUiController = rememberSystemUiController()
//    val darkIcons = MaterialTheme.colors.isLight
        SideEffect {
            systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = false)
        }

        val navController = rememberNavController()
        val navigationActions = remember(navController) {
            CryptoCoinNavigationActions(navController)
        }

        val coroutineScope = rememberCoroutineScope()

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route ?: CryptoCoinDestinations.DASHBOARD_ROUTE

        val isExpandedScreen = windowSize == WindowSize.Expanded
        CryptoCoinNavGraph(
            isExpandedScreen = isExpandedScreen,
            navController = navController,
            startDestination = currentRoute
        )

    }

}