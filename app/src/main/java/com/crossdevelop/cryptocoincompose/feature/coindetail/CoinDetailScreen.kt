package com.crossdevelop.cryptocoincompose.feature.coindetail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.crossdevelop.cryptocoincompose.R
import com.crossdevelop.cryptocoincompose.common.models.CoinDetail
import com.crossdevelop.cryptocoincompose.common.ui.composables.CircularProgressLoadingScreen
import com.crossdevelop.cryptocoincompose.common.ui.theme.CryptoCoinTheme
import com.crossdevelop.cryptocoincompose.common.ui.theme.Red200
import com.crossdevelop.cryptocoincompose.common.ui.theme.border_stroke_medium
import com.crossdevelop.cryptocoincompose.common.ui.theme.border_stroke_small
import com.crossdevelop.cryptocoincompose.common.ui.theme.elevation_card
import com.crossdevelop.cryptocoincompose.common.ui.theme.spacing_default
import com.crossdevelop.cryptocoincompose.common.ui.theme.spacing_large
import com.crossdevelop.cryptocoincompose.common.ui.theme.spacing_zero
import com.crossdevelop.cryptocoincompose.common.utils.BackPressHandler
import com.crossdevelop.cryptocoincompose.common.utils.parseHtml
import com.crossdevelop.cryptocoincompose.core.composables.ConfirmationDialog
import com.crossdevelop.cryptocoincompose.core.composables.InsetAwareTopAppBar
import com.crossdevelop.cryptocoincompose.feature.AppContainer


@Composable
fun CoinDetailScreen(appContainer: AppContainer) {

    val viewModel: CoinDetailViewModel = hiltViewModel()

    val showDialog = remember { mutableStateOf(false) }
    if (showDialog.value) {
        ConfirmationDialog(
            showDialog = showDialog,
            title = stringResource(R.string.leave_this_page),
            body = stringResource(R.string.do_you_really_want_to_leave_this_page),
            onConfirm = {
                appContainer.pressBack()
            })
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
                    imageVector = Icons.Filled.ArrowBack,
                    colorFilter = ColorFilter.tint(Color.White),
                    contentDescription = stringResource(R.string.navigate_back)
                )
            },
            title = { Text(stringResource(R.string.coin_info)) }
        )

        val viewState by viewModel.coinDetail.collectAsState()
        when (viewState) {
            is CoinDetailViewModel.ViewState.Loading -> {
                CircularProgressLoadingScreen()
            }
            is CoinDetailViewModel.ViewState.CoinDetailResult -> {
                SuccessScreen(coinDetail = (viewState as CoinDetailViewModel.ViewState.CoinDetailResult).coinDetail)
            }
        }
    }
}

@Composable
private fun SuccessScreen(coinDetail: CoinDetail) {

    Column(modifier = Modifier.scrollable(state = rememberScrollState(), enabled = true, orientation = Orientation.Vertical)) {

        if (!coinDetail.publicNotice.isNullOrBlank()) {
            Surface(
                modifier = Modifier.padding(
                    start = spacing_large,
                    end = spacing_large,
                    bottom = spacing_zero,
                    top = spacing_large
                ),
                color = Red200,
                shape = MaterialTheme.shapes.large,
                border = BorderStroke(border_stroke_medium, Color.Red),
                elevation = elevation_card
            ) {
                Text(modifier = Modifier.padding(spacing_large), text = coinDetail.publicNotice.parseHtml())
            }
        }

        Row(
            modifier = Modifier.padding(
                start = spacing_large,
                end = spacing_large,
                bottom = spacing_default,
                top = spacing_large
            )
        ) {
            AsyncImage(
                modifier = Modifier.align(Alignment.CenterVertically),
                model = coinDetail.image.large,
                contentDescription = "coin image"
            )
            Text(
                modifier = Modifier.padding(
                    start = spacing_large,
                    end = spacing_zero,
                    bottom = spacing_zero,
                    top = spacing_zero
                ),
                text = "${coinDetail.name}\n(${coinDetail.symbol})",
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.Bold
            )
        }

        coinDetail.description?.let {
            Surface(
                modifier = Modifier.padding(horizontal = spacing_large, vertical = spacing_default),
                shape = MaterialTheme.shapes.large,
                border = BorderStroke(border_stroke_small, MaterialTheme.colors.secondary),
                elevation = elevation_card
            ) {
                Text(modifier = Modifier.padding(spacing_large), text = it)
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CryptoCoinTheme {
        CoinDetailScreen(AppContainer(rememberNavController()))
    }
}