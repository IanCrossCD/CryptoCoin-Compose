package com.crossdevelop.cryptocoincompose.feature

import androidx.navigation.NavHostController


class AppContainer(val navController: NavHostController)  {

    val onBack: () -> Unit = {
        navController.popBackStack()
    }

    fun pressBack() {
        onBack.invoke()
    }
}