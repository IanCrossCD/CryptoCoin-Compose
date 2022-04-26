package com.crossdevelop.cryptocoincompose.feature.coindetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.crossdevelop.cryptocoincompose.common.models.CoinDetail
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
    Column(modifier = Modifier.padding(spacing_large)) {
        Text(style = MaterialTheme.typography.h6, text = "ETH: ${coinDetail.currentPrices.eth}")
        Text(style = MaterialTheme.typography.h5, text = "BTC: ${coinDetail.currentPrices.btc}", modifier = Modifier.padding(horizontal = 24.dp, vertical = spacing_default))
        Text(style = MaterialTheme.typography.h4, text = "USD: ${coinDetail.currentPrices.usd}", modifier = Modifier.padding(horizontal = 48.dp))
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    CryptoCoinTheme {
//        CoinDetailInfoScreen(AppContainer(rememberNavController(), rememberScaffoldState()))
//    }
//}