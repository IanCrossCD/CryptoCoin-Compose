package com.crossdevelop.cryptocoincompose.feature.coindashboard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.crossdevelop.cryptocoincompose.common.models.CoinList
import com.crossdevelop.cryptocoincompose.common.ui.theme.Grey200
import com.crossdevelop.cryptocoincompose.common.ui.theme.spacing_small
import com.crossdevelop.cryptocoincompose.common.ui.theme.spacing_zero


@Composable
fun CoinListItem(
    modifier: Modifier,
    coin: CoinList,
    onClick: () -> Unit,
    onFav: () -> Unit
) {

    Surface(modifier = Modifier.clickable(enabled = true, onClick = onClick)) {

        Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {

            Column(modifier = Modifier.weight(1f, true)) {

                Text(
                    modifier = Modifier.padding(spacing_zero, spacing_zero, spacing_zero, spacing_small),
                    style = MaterialTheme.typography.h5,
                    text = coin.symbol
                )

                Text(text = coin.name)

            }

            Check(checked = coin.favorite, onClick = onFav)
        }

    }
}

@Composable
fun Check(checked: Boolean, onClick: () -> Unit) {
    val icon = if (checked) Icons.Filled.Favorite else Icons.Outlined.Favorite
    val color = if (checked) MaterialTheme.colors.error else Grey200
    Button(
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        elevation = ButtonDefaults.elevation(spacing_zero),
        contentPadding = PaddingValues(spacing_small),
        modifier = Modifier
            .clip(CircleShape)
            .size(50.dp),
        onClick = onClick
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "${if (checked) "un" else ""}favorite",
            tint = color
        )
    }
}