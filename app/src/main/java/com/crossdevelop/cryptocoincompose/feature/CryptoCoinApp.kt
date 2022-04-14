package com.crossdevelop.cryptocoincompose.feature

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.crossdevelop.cryptocoincompose.common.utils.WindowSize
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun CryptoCoinApp() {

    val scaffoldState = rememberScaffoldState()
    val navController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()

    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = false)
    }

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: CryptoCoinDestinations.DASHBOARD_ROUTE

    Scaffold(
        modifier = Modifier,
        scaffoldState = scaffoldState,
        snackbarHost = { scaffoldState.snackbarHostState }
    ) {

        Box(modifier = Modifier) {

            CryptoCoinNavGraph(
                modifier = Modifier,
                navController = navController,
                startDestination = currentRoute
            )

//            Snackbar(
//                snackbarHostState = scaffoldState.snackbarHostState,
//                onDismiss = { scaffoldState.snackbarHostState.currentSnackbarData?.dismiss() },
//                modifier = Modifier.align(Alignment.BottomCenter)
//            )

        }
    }

}