package com.crossdevelop.cryptocoincompose.feature.coindetail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.crossdevelop.cryptocoincompose.R
import com.crossdevelop.cryptocoincompose.common.extensions.round
import com.crossdevelop.cryptocoincompose.common.domain.models.CoinDetail
import com.crossdevelop.cryptocoincompose.common.ui.composables.TiledBackground
import com.crossdevelop.cryptocoincompose.common.ui.theme.ObtuseShape
import com.crossdevelop.cryptocoincompose.common.ui.theme.border_stroke_small
import com.crossdevelop.cryptocoincompose.common.ui.theme.elevation_card
import com.crossdevelop.cryptocoincompose.common.ui.theme.spacing_default
import com.crossdevelop.cryptocoincompose.common.ui.theme.spacing_large
import com.crossdevelop.cryptocoincompose.feature.AppContainer
import com.google.accompanist.insets.navigationBarsPadding


@Composable
fun CoinDetailMarketScreen(appContainer: AppContainer, coinDetail: CoinDetail) {

    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = scrollState)
            .navigationBarsPadding(),
    ) {

        MarketValueRow(coinDetail = coinDetail)

    }
}

@Composable
private fun MarketValueRow(coinDetail: CoinDetail) {
    Surface(
        modifier = Modifier
            .padding(horizontal = spacing_large, vertical = spacing_default),
        shape = ObtuseShape,
        border = BorderStroke(border_stroke_small, MaterialTheme.colors.secondary),
        elevation = elevation_card
    ) {

        TiledBackground(patternRes = R.drawable.img_dots_pattern)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colors.background.copy(alpha = .5f),
                            MaterialTheme.colors.background
                        )
                    )
                )
                .padding(spacing_large)
        ) {
            Text(style = MaterialTheme.typography.body1, text = "ETH: ${coinDetail.currentPrices.eth.round(2)}")
            Text(
                style = MaterialTheme.typography.body1,
                text = "BTC: ${coinDetail.currentPrices.btc.round(2)}",
                modifier = Modifier.padding(horizontal = 24.dp, vertical = spacing_default)
            )
            Text(style = MaterialTheme.typography.h4, text = "$${coinDetail.currentPrices.usd.round(2)}", modifier = Modifier.padding(horizontal = 48.dp))
        }
    }
}