package com.crossdevelop.cryptocoincompose.feature.coindetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.crossdevelop.cryptocoincompose.R
import com.crossdevelop.cryptocoincompose.common.ui.composables.InsetAwareTopAppBar
import com.crossdevelop.cryptocoincompose.common.ui.theme.CryptoCoinTheme
import com.crossdevelop.cryptocoincompose.common.ui.theme.White
import com.crossdevelop.cryptocoincompose.common.ui.theme.spacing_default
import com.crossdevelop.cryptocoincompose.common.ui.theme.spacing_small
import com.crossdevelop.cryptocoincompose.feature.AppContainer
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class, ExperimentalPagerApi::class)
@Composable
fun CoinDetailScreen(appContainer: AppContainer) {

    val viewModel: CoinDetailViewModel = hiltViewModel()
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState(0)

    Column(Modifier.fillMaxSize()) {

        InsetAwareTopAppBar(
            navigationIcon = {
                Image(
                    modifier = Modifier
                        .clickable { appContainer.pressBack() }
                        .padding(spacing_default),
                    imageVector = Icons.Filled.ArrowBack,
                    colorFilter = ColorFilter.tint(Color.White),
                    contentDescription = stringResource(R.string.navigate_back)
                )
            },
            title = { Text(stringResource(R.string.coin_info)) }
        )

        TabRow(
            selectedTabIndex = pagerState.currentPage,
            backgroundColor = MaterialTheme.colors.secondary,
            contentColor = White,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    modifier = Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                    color = MaterialTheme.colors.primaryVariant
                )
            }) {
            Tab(
                modifier = Modifier.padding(spacing_small),
                text = { Text("Info") },
                selected = pagerState.currentPage == 0,
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(0)
                    }
                },
            )
            Tab(
                modifier = Modifier.padding(spacing_small),
                text = { Text("Market Info") },
                selected = pagerState.currentPage == 1,
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(1)
                    }
                },
            )
        }

        HorizontalPager(
            modifier = Modifier.fillMaxSize(),
            state = pagerState,
            count = 2
        ) { page ->
            if (page == 0) {
                CoinDetailInfoScreen(appContainer = appContainer)
            } else if (page == 1) {
                CoinDetailInfoScreen(appContainer = appContainer)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CryptoCoinTheme {
        CoinDetailScreen(AppContainer(rememberNavController(), rememberScaffoldState()))
    }
}