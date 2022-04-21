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
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.crossdevelop.cryptocoincompose.R
import com.crossdevelop.cryptocoincompose.common.models.CoinList
import com.crossdevelop.cryptocoincompose.common.ui.composables.CircularProgressLoadingScreen
import com.crossdevelop.cryptocoincompose.common.ui.composables.ConfirmationDialog
import com.crossdevelop.cryptocoincompose.common.ui.composables.InsetAwareTopAppBar
import com.crossdevelop.cryptocoincompose.common.ui.composables.SearchBar
import com.crossdevelop.cryptocoincompose.common.ui.theme.CryptoCoinTheme
import com.crossdevelop.cryptocoincompose.common.ui.theme.spacing_default
import com.crossdevelop.cryptocoincompose.common.ui.theme.spacing_large
import com.crossdevelop.cryptocoincompose.common.ui.theme.spacing_xlarge
import com.crossdevelop.cryptocoincompose.common.utils.BackPressHandler
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
    val coroutineScope = rememberCoroutineScope()

    val eventState by viewModel.viewEvent.collectAsState()
    when (eventState) {
        is CoinDashboardViewModel.ViewEvent.GoToCoinDetail -> {
            viewModel.consumedEvent()
            appContainer.navController.navigateCoinListToCoinDetail((eventState as CoinDashboardViewModel.ViewEvent.GoToCoinDetail).coinId)
        }
        is CoinDashboardViewModel.ViewEvent.FavoriteChanged -> {
            viewModel.consumedEvent()
            val state = eventState as CoinDashboardViewModel.ViewEvent.FavoriteChanged
            val message = if (state.favorited) {
                stringResource(R.string.favorited_s, state.coinName)
            } else {
                stringResource(R.string.unfavorited_s, state.coinName)
            }
            showSnack(coroutineScope, appContainer, message)
        }
        else -> {
            // No Impl
        }
    }

    val showDialog = remember { mutableStateOf(false) }
    if (showDialog.value) {
        ConfirmationDialog(
            showDialog = showDialog,
            title = stringResource(R.string.leave_this_page),
            body = stringResource(R.string.do_you_really_want_to_leave_this_page),
            onConfirm = {
                viewModel.handleError(Throwable("At App Root"))
            })
    }

    val onBack = { showDialog.value = true }
    BackPressHandler(onBackPressed = onBack)

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
            val favoriteCoins = coins.filter { it.favorite }
            val otherCoins = coins.filter { !it.favorite }
            itemsIndexed(favoriteCoins) { index, coin ->
                if (index == 0) {
                    CoinListDivider(text = "Favorites")
                }
                CoinListItem(
                    modifier = Modifier.padding(horizontal = spacing_large, vertical = spacing_default),
                    coin = coin,
                    onClick = {
                        viewModel.goToCoinDetail(coin.id)
                    },
                    onFav = {
                        viewModel.deleteFavoriteCoin(coin)
                    })
            }
            itemsIndexed(otherCoins) { index, coin ->
                if (index == 0) {
                    CoinListDivider(text = stringResource(R.string.currencies))
                }
                CoinListItem(
                    modifier = Modifier.padding(horizontal = spacing_large, vertical = spacing_default),
                    coin = coin,
                    onClick = {
                        viewModel.goToCoinDetail(coin.id)
                    },
                    onFav = {
                        viewModel.favoriteCoin(coin)
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

fun showSnack(coroutineScope: CoroutineScope, appContainer: AppContainer, message: String) {
    coroutineScope.launch {
        appContainer.scaffoldState.snackbarHostState.showSnackbar(message)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CryptoCoinTheme {
        CoinDashboardScreen(AppContainer(rememberNavController(), rememberScaffoldState()))
    }
}