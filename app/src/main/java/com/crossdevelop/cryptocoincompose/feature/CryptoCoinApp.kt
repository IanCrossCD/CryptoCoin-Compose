package com.crossdevelop.cryptocoincompose.feature

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun CryptoCoinApp(appContainer: AppContainer) {

    val viewModel: MainActivityViewModel = hiltViewModel()

    val scaffoldState = rememberScaffoldState()

    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = false)
    }

//    val navBackStackEntry by appContainer.navController.currentBackStackEntryAsState()
//    val currentRoute = navBackStackEntry?.destination?.route ?: CryptoCoinDestinations.DASHBOARD_ROUTE

    Scaffold(
        modifier = Modifier,
        scaffoldState = scaffoldState,
        snackbarHost = { scaffoldState.snackbarHostState }
    ) {

        Box(modifier = Modifier.fillMaxSize()) {

            CryptoCoinNavGraph(
                modifier = Modifier,
                appContainer = appContainer,
                startDestination = CryptoCoinDestinations.DASHBOARD_ROUTE
            )

            val snackMessage: String? by viewModel.activitySnack.collectAsState()
            snackMessage?.let {
                Snackbar(
                    modifier = Modifier.align(Alignment.BottomCenter)
                ) {
                    Text(text = it)
                }
            }

//            viewModel.activitySnack.value = "Test"

        }
    }

}