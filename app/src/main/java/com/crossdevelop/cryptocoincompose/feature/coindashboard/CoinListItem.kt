package com.crossdevelop.cryptocoincompose.feature.coindashboard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.crossdevelop.cryptocoincompose.common.models.CoinList
import com.crossdevelop.cryptocoincompose.common.ui.theme.spacing_small
import com.crossdevelop.cryptocoincompose.common.ui.theme.spacing_zero


@Composable
fun CoinListItem(
    modifier: Modifier,
    coin: CoinList,
    onClick: () -> Unit
) {

    Column(modifier = modifier
        .clickable(enabled = true, onClick = onClick)
        .fillMaxWidth()) {

        Text(
            modifier = Modifier.padding(spacing_zero, spacing_zero, spacing_zero, spacing_small),
            style = MaterialTheme.typography.h5,
            text = coin.symbol
        )

        Text(text = coin.name)
    }

}