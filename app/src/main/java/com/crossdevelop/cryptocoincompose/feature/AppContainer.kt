package com.crossdevelop.cryptocoincompose.feature

import androidx.compose.material.ScaffoldState
import androidx.navigation.NavHostController


class AppContainer(
    val navController: NavHostController,
    val scaffoldState: ScaffoldState
) {

    val onBack: () -> Unit = {
        navController.popBackStack()
    }

    fun pressBack() {
        onBack.invoke()
    }
}