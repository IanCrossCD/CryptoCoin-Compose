package com.crossdevelop.cryptocoincompose.core.ui

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.contentColorFor
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.crossdevelop.cryptocoincompose.BuildConfig
import com.crossdevelop.cryptocoincompose.common.ui.theme.spacing_small
import com.crossdevelop.cryptocoincompose.common.ui.theme.spacing_zero
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding
import java.time.LocalTime


@Composable
fun InsetAwareTopAppBar(
    title: String,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
    backgroundColor: Color = MaterialTheme.colors.primarySurface,
    contentColor: Color = contentColorFor(backgroundColor),
    elevation: Dp = spacing_small
) {
    Surface(
        color = backgroundColor,
        elevation = elevation,
        modifier = modifier
    ) {

        val curTime = LocalTime.now()
        val appBarTitle = "$title : ${curTime.hour}:${curTime.minute}"

        TopAppBar(
            title = { Text(appBarTitle) },
            navigationIcon = navigationIcon,
            actions = actions,
            backgroundColor = Color.Transparent,
            contentColor = contentColor,
            elevation = spacing_zero,
            modifier = Modifier
                .statusBarsPadding()
                .navigationBarsPadding(bottom = false)
        )
    }
}