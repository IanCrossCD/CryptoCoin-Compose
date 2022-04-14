package com.crossdevelop.cryptocoincompose.feature.coindashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.crossdevelop.cryptocoincompose.R
import com.crossdevelop.cryptocoincompose.common.ui.theme.CryptoCoinTheme
import com.crossdevelop.cryptocoincompose.common.ui.theme.spacing_default
import com.crossdevelop.cryptocoincompose.common.ui.theme.spacing_large
import com.crossdevelop.cryptocoincompose.core.ui.InsetAwareTopAppBar
import com.crossdevelop.cryptocoincompose.feature.CryptoCoinNavigationActions
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun CoinDashboardScreen() {

    val viewModel: CoinDashboardViewModel = hiltViewModel()

    val navigationBarPaddingValues = rememberInsetsPaddingValues(insets = LocalWindowInsets.current.navigationBars)

    val navController = rememberNavController()
    val columnState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column {

        InsetAwareTopAppBar(
            title = stringResource(R.string.crypto_compose),
            actions = {
                onAppBarClick(coroutineScope, columnState)
            }
        )

        val coins by viewModel.coins.observeAsState(initial = emptyList())

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            state = columnState,
            contentPadding = PaddingValues(bottom = navigationBarPaddingValues.calculateBottomPadding()),
            verticalArrangement = Arrangement.spacedBy(spacing_default)
        ) {
            items(coins) {
                CoinListItem(modifier = Modifier.padding(horizontal = spacing_large), coin = it, onClick = {
                    with(CryptoCoinNavigationActions(navController = navController)) {
                        coinId = it.id
                        navigateToDetail
                    }
                })
            }
        }
    }
}

fun onAppBarClick(coroutineScope: CoroutineScope, columnState: LazyListState) {
    coroutineScope.launch {
        // Animate scroll to the first item
        columnState.scrollToItem(index = 0)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CryptoCoinTheme {
        CoinDashboardScreen()
    }
}