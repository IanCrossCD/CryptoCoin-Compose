package com.crossdevelop.cryptocoincompose.feature.coindetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.crossdevelop.cryptocoincompose.R
import com.crossdevelop.cryptocoincompose.common.models.CoinDetail
import com.crossdevelop.cryptocoincompose.common.ui.CircularProgressLoadingScreen
import com.crossdevelop.cryptocoincompose.common.ui.theme.CryptoCoinTheme
import com.crossdevelop.cryptocoincompose.common.ui.theme.spacing_default
import com.crossdevelop.cryptocoincompose.common.utils.BackPressHandler
import com.crossdevelop.cryptocoincompose.core.ui.InsetAwareTopAppBar
import com.crossdevelop.cryptocoincompose.feature.AppContainer


@Composable
fun CoinDetailScreen(appContainer: AppContainer) {

    val viewModel: CoinDetailViewModel = hiltViewModel()

    val showDialog = remember { mutableStateOf(false) }
    if (showDialog.value) {
        ConfirmationDialog(appContainer = appContainer, showDialog = showDialog)
    }

    val onBack = { showDialog.value = true }
    BackPressHandler(onBackPressed = onBack)

    Column {

        InsetAwareTopAppBar(
            navigationIcon = {
                Image(
                    modifier = Modifier
                        .clickable {
                            onBack.invoke()
                        }
                        .padding(spacing_default),
                    painter = painterResource(R.drawable.ic_arrow_back_24),
                    contentDescription = "navigate back"
                )
            },
            title = { Text("Coin Info") }
        )

        val viewState by viewModel.coinDetail.collectAsState()
        when (viewState) {
            is CoinDetailViewModel.ViewState.Loading -> {
                CircularProgressLoadingScreen()
            }
            is CoinDetailViewModel.ViewState.CoinDetailResult -> {
                SuccessScreen(coinDetail = (viewState as CoinDetailViewModel.ViewState.CoinDetailResult).coinDetail)
            }
            is CoinDetailViewModel.ViewState.Error -> {

            }
        }
    }
}

@Composable
private fun SuccessScreen(coinDetail: CoinDetail) {
    coinDetail.description?.let {
        Text(text = it)
    }

}

@Composable
private fun ConfirmationDialog(appContainer: AppContainer, showDialog: MutableState<Boolean>) {
    AlertDialog(onDismissRequest = {
        showDialog.value = false
    }, title = {
        Text("Are you sure?")
    }, text = {
        Text("Do you really want to leave this page")
    }, confirmButton = {
        Button(onClick = {
            appContainer.pressBack()
        }) {
            Text(text = "Yes")
        }
    })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CryptoCoinTheme {
        CoinDetailScreen(AppContainer(rememberNavController()))
    }
}