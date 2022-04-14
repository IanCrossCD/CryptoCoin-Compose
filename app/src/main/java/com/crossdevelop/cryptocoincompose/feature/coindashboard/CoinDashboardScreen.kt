package com.crossdevelop.cryptocoincompose.feature.coindashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.crossdevelop.cryptocoincompose.R
import com.crossdevelop.cryptocoincompose.common.ui.theme.CryptoCoinTheme
import com.crossdevelop.cryptocoincompose.common.ui.theme.spacing_large
import com.crossdevelop.cryptocoincompose.core.ui.InsetAwareTopAppBar
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues


@Composable
fun DashboardScreen() {

    val viewModel: CoinDashboardViewModel = hiltViewModel()

    val navigationBarPaddingValues = rememberInsetsPaddingValues(insets = LocalWindowInsets.current.navigationBars)

    Column {

        InsetAwareTopAppBar(
            title = { Text(text = stringResource(R.string.crypto_compose)) },
//        navigationIcon = navigationIcon,
//        actions = actions,
            elevation = 0.dp
        )

        val coins by viewModel.coins.observeAsState(initial = emptyList())

        LazyColumn(
            contentPadding = PaddingValues(bottom = navigationBarPaddingValues.calculateBottomPadding()),
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(coins) {
                CoinListItem(modifier = Modifier, coin = it)
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CryptoCoinTheme {
        DashboardScreen()
    }
}