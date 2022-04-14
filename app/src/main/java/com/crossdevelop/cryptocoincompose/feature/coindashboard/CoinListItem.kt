package com.crossdevelop.cryptocoincompose.feature.coindashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.crossdevelop.cryptocoincompose.common.models.CoinList
import com.crossdevelop.cryptocoincompose.common.ui.theme.spacing_default
import com.crossdevelop.cryptocoincompose.common.ui.theme.spacing_large
import com.crossdevelop.cryptocoincompose.common.ui.theme.spacing_small
import com.crossdevelop.cryptocoincompose.common.ui.theme.spacing_zero


@Composable
fun CoinListItem(
    modifier: Modifier,
    coin: CoinList
) {

    Column(modifier = modifier.padding(horizontal = spacing_large, vertical = spacing_default)) {

        Text(modifier = Modifier.padding(spacing_zero, spacing_zero, spacing_zero, spacing_small),
            style = MaterialTheme.typography.h5,
            text = coin.symbol)

        Text(text = coin.name)
    }

}