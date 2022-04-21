package com.crossdevelop.cryptocoincompose.feature

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch


@Composable
fun CryptoCoinApp() {

    val viewModel: CryptoCoinAppViewModel = hiltViewModel()

    val coroutineScope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()

    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = false)
    }

    val appContainer = AppContainer(rememberNavController(), scaffoldState)

    Scaffold(
        modifier = Modifier,
        scaffoldState = scaffoldState
    ) {

        Box(modifier = Modifier.fillMaxSize()) {

            CryptoCoinNavGraph(
                modifier = Modifier,
                appContainer = appContainer,
                startDestination = CryptoCoinDestinations.DASHBOARD_ROUTE
            )

            val snackMessage: String? by viewModel.activitySnack.collectAsState()
            snackMessage?.let {
                coroutineScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(it)
                }
            }

        }
    }

}