package com.crossdevelop.cryptocoincompose.feature.coindashboard

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable


@Composable
fun DashboardRoute(
//    interestsViewModel: InterestsViewModel,
    scaffoldState: ScaffoldState = rememberScaffoldState()
) {
//    val tabContent = rememberTabContent(interestsViewModel)
//    val (currentSection, updateSection) = rememberSaveable {
//        mutableStateOf(tabContent.first().section)
//    }

    DashboardScreen(
//        currentSection = currentSection,
//        isExpandedScreen = isExpandedScreen,
//        scaffoldState = scaffoldState
    )
}