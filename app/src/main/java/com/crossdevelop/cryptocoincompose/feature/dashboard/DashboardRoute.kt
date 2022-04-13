package com.crossdevelop.cryptocoincompose.feature.dashboard

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable


@Composable
fun DashboardRoute(
//    interestsViewModel: InterestsViewModel,
    isExpandedScreen: Boolean,
//    openDrawer: () -> Unit,
    scaffoldState: ScaffoldState = rememberScaffoldState()
) {
//    val tabContent = rememberTabContent(interestsViewModel)
//    val (currentSection, updateSection) = rememberSaveable {
//        mutableStateOf(tabContent.first().section)
//    }

    DashboardScreen(
        name = "TESTER"
//        tabContent = tabContent,
//        currentSection = currentSection,
//        isExpandedScreen = isExpandedScreen,
//        onTabChange = updateSection,
//        openDrawer = openDrawer,
//        scaffoldState = scaffoldState
    )
}