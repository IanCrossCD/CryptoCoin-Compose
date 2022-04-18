package com.crossdevelop.cryptocoincompose.feature.coindashboard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.crossdevelop.cryptocoincompose.R
import com.crossdevelop.cryptocoincompose.common.models.CoinList
import com.crossdevelop.cryptocoincompose.common.ui.CircularProgressLoadingScreen
import com.crossdevelop.cryptocoincompose.common.ui.theme.CryptoCoinTheme
import com.crossdevelop.cryptocoincompose.common.ui.theme.spacing_default
import com.crossdevelop.cryptocoincompose.common.ui.theme.spacing_large
import com.crossdevelop.cryptocoincompose.common.utils.BackPressHandler
import com.crossdevelop.cryptocoincompose.core.ui.InsetAwareTopAppBar
import com.crossdevelop.cryptocoincompose.feature.AppContainer
import com.crossdevelop.cryptocoincompose.feature.coindetail.navigateCoinListToCoinDetail
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun CoinDashboardScreen(appContainer: AppContainer) {

    val viewModel: CoinDashboardViewModel = hiltViewModel()

    val columnState = rememberLazyListState()
    val swipeState = rememberSwipeRefreshState(isRefreshing = false)
    val coroutineScope = rememberCoroutineScope()

//    val eventState by viewModel.coinDashboardEvent.collectAsState()
//    when (eventState) {
//        is CoinDashboardViewModel.CoinDashboardEvent.GoToCoinDetail -> {
//            appContainer.navController.navigateCoinListToCoinDetail((eventState as CoinDashboardViewModel.CoinDashboardEvent.GoToCoinDetail).coinId)
//        }
//        else -> {}
//    }

    Column {

        InsetAwareTopAppBar(
            title = {
                Text(
                    modifier = Modifier.clickable {
                        onAppBarClick(coroutineScope, columnState)
                    }, text = stringResource(R.string.crypto_compose)
                )
            },
        )

        SwipeRefresh(state = swipeState, onRefresh = {
            // TODO revisit refresh loading
            viewModel.getCoinList()
        }) {
            val viewState by viewModel.viewState.collectAsState()
            when (viewState) {
                is CoinDashboardViewModel.ViewState.Loading -> {
                    CircularProgressLoadingScreen()
                }
                is CoinDashboardViewModel.ViewState.CoinListResult -> {
                    SuccessScreen(
                        coins = (viewState as CoinDashboardViewModel.ViewState.CoinListResult).coins,
                        navController = appContainer.navController,
                        viewModel = viewModel,
                        columnState = columnState
                    )
                }
            }
        }
    }
}

@Composable
private fun SuccessScreen(
    coins: List<CoinList>,
    viewModel: CoinDashboardViewModel,
    navController: NavHostController,
    columnState: LazyListState,
) {

    val navigationBarPaddingValues = rememberInsetsPaddingValues(insets = LocalWindowInsets.current.navigationBars)

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        state = columnState,
        contentPadding = PaddingValues(bottom = navigationBarPaddingValues.calculateBottomPadding())
    ) {
        items(coins) { coin ->
            CoinListItem(
                modifier = Modifier.padding(horizontal = spacing_large, vertical = spacing_default),
                coin = coin,
                onClick = {
//                    viewModel.goToCoinDetail(coin.id)
                    navController.navigateCoinListToCoinDetail(coin.id)
                })
        }
    }
}


fun onAppBarClick(coroutineScope: CoroutineScope, columnState: LazyListState) {
    coroutineScope.launch {
        // Animate scroll to the first item
        columnState.animateScrollToItem(index = 0)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CryptoCoinTheme {
        CoinDashboardScreen(AppContainer(rememberNavController()))
    }
}