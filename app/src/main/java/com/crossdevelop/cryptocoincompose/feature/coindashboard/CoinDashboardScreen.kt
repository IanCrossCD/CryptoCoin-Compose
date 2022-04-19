package com.crossdevelop.cryptocoincompose.feature.coindashboard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.navigation.compose.rememberNavController
import com.crossdevelop.cryptocoincompose.R
import com.crossdevelop.cryptocoincompose.common.models.CoinList
import com.crossdevelop.cryptocoincompose.common.ui.composables.CircularProgressLoadingScreen
import com.crossdevelop.cryptocoincompose.common.ui.theme.CryptoCoinTheme
import com.crossdevelop.cryptocoincompose.common.ui.theme.spacing_default
import com.crossdevelop.cryptocoincompose.common.ui.theme.spacing_large
import com.crossdevelop.cryptocoincompose.common.ui.theme.spacing_xlarge
import com.crossdevelop.cryptocoincompose.common.utils.BackPressHandler
import com.crossdevelop.cryptocoincompose.core.composables.InsetAwareTopAppBar
import com.crossdevelop.cryptocoincompose.core.composables.SearchBar
import com.crossdevelop.cryptocoincompose.feature.AppContainer
import com.crossdevelop.cryptocoincompose.feature.coindetail.navigateCoinListToCoinDetail
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun CoinDashboardScreen(appContainer: AppContainer) {

    val viewModel: CoinDashboardViewModel = hiltViewModel()

    val columnState = rememberLazyListState()
//    val swipeState = rememberSwipeRefreshState(isRefreshing = false)
    val coroutineScope = rememberCoroutineScope()

    val onBack = {
        viewModel.handleError("At Root Compose")
    }
    BackPressHandler(onBackPressed = onBack)

    val eventState by viewModel.viewEvent.collectAsState()
    when (eventState) {
        is CoinDashboardViewModel.ViewEvent.GoToCoinDetail -> {
            viewModel.consumedEvent()
            appContainer.navController.navigateCoinListToCoinDetail((eventState as CoinDashboardViewModel.ViewEvent.GoToCoinDetail).coinId)
        }
        else -> {
            // No Impl
        }
    }

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

        val viewState by viewModel.viewState.collectAsState()

        SearchBar(
            query = viewState.query,
            onQuery = {
                viewModel.queryCoins(it)
            })

//        SwipeRefresh(state = swipeState, onRefresh = {
//            // TODO revisit refresh loading
//            viewModel.getCoinList()
//        }) {

        when (viewState) {
            is CoinDashboardViewModel.ViewState.Loading -> {
                CircularProgressLoadingScreen()
            }
            is CoinDashboardViewModel.ViewState.CoinListResult -> {
                SuccessScreen(
                    coins = (viewState as CoinDashboardViewModel.ViewState.CoinListResult).coins,
                    viewModel = viewModel,
                    columnState = columnState
                )
            }
        }
//        }
    }
}

@Composable
private fun SuccessScreen(
    coins: List<CoinList>,
    viewModel: CoinDashboardViewModel,
    columnState: LazyListState
) {

    val navigationBarPaddingValues = rememberInsetsPaddingValues(insets = LocalWindowInsets.current.navigationBars)

    if (coins.isNotEmpty()) {

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            state = columnState,
            contentPadding = PaddingValues(
                bottom = navigationBarPaddingValues.calculateBottomPadding()
            )
        ) {
            itemsIndexed(coins) { index, coin ->
                if (index == 0) {
                    CoinListDivider(text = "Available Currency")
                }
                CoinListItem(
                    modifier = Modifier.padding(horizontal = spacing_large, vertical = spacing_default),
                    coin = coin,
                    onClick = {
                        viewModel.goToCoinDetail(coin.id)
                    })
            }
        }
    } else {
        Text(modifier = Modifier.padding(spacing_xlarge), text = stringResource(R.string.oops_nothing_was_found))
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