package com.crossdevelop.cryptocoincompose.common.ui.composables

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.ImageShader
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.res.imageResource

@Composable
fun TiledBackground(
    modifier: Modifier = Modifier,
    patternRes: Int
) {
    val pattern = ImageBitmap.imageResource(id = patternRes)
    Canvas(
        modifier = modifier
            .fillMaxSize()

    ) {
        val paint = Paint()
            .asFrameworkPaint()
            .apply {
                isAntiAlias = true
                shader = ImageShader(pattern, TileMode.Repeated, TileMode.Repeated)
            }

        drawIntoCanvas {
            it.nativeCanvas.drawPaint(paint)
        }
        paint.reset()
    }
}