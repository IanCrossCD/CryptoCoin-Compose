package com.crossdevelop.cryptocoincompose.feature.coindashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.crossdevelop.cryptocoincompose.common.ui.theme.Grey200
import com.crossdevelop.cryptocoincompose.common.ui.theme.spacing_large
import com.crossdevelop.cryptocoincompose.common.ui.theme.spacing_small


@Composable
fun CoinListDivider(
    modifier: Modifier = Modifier,
    text: String
) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .background(Grey200)
            .padding(horizontal = spacing_large, vertical = spacing_small),
        style = MaterialTheme.typography.caption,
        text = text
    )
}