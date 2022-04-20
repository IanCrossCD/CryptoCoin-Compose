package com.crossdevelop.cryptocoincompose.common.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.crossdevelop.cryptocoincompose.common.ui.CryptoIcons


public val CryptoIcons.Bitbucket: ImageVector
    get() {
        if (_bitbucket != null) {
            return _bitbucket!!
        }
        _bitbucket = Builder(
            name = "Bitbucket", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
            viewportWidth = 24.0f, viewportHeight = 24.0f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(12.0f, 2.0f)
                curveTo(8.1172f, 2.0f, 4.0f, 2.5938f, 4.0f, 5.0f)
                curveTo(4.0f, 6.5156f, 4.5664f, 10.9023f, 4.8438f, 12.9375f)
                curveTo(4.9375f, 13.6172f, 5.3711f, 14.2188f, 6.0f, 14.5f)
                curveTo(6.0f, 14.5f, 8.0f, 16.0f, 12.0f, 16.0f)
                curveTo(16.0f, 16.0f, 18.0f, 14.5f, 18.0f, 14.5f)
                curveTo(18.6289f, 14.2188f, 19.0625f, 13.6172f, 19.1563f, 12.9375f)
                curveTo(19.4336f, 10.9023f, 20.0f, 6.5156f, 20.0f, 5.0f)
                curveTo(20.0f, 2.5938f, 15.8828f, 2.0f, 12.0f, 2.0f)
                close()
                moveTo(12.0f, 4.0f)
                curveTo(15.8125f, 4.0f, 17.875f, 5.0664f, 18.0625f, 5.5f)
                curveTo(18.0117f, 5.6172f, 17.8047f, 5.7891f, 17.4688f, 5.9688f)
                curveTo(16.5938f, 6.4414f, 14.7617f, 7.0f, 12.0f, 7.0f)
                curveTo(9.1055f, 7.0f, 7.2266f, 6.375f, 6.4063f, 5.9063f)
                curveTo(6.1289f, 5.75f, 5.9688f, 5.6289f, 5.9375f, 5.5313f)
                curveTo(6.0664f, 5.1133f, 8.1289f, 4.0f, 12.0f, 4.0f)
                close()
                moveTo(12.0f, 9.0f)
                curveTo(13.6523f, 9.0f, 15.0f, 10.3477f, 15.0f, 12.0f)
                curveTo(15.0f, 13.6523f, 13.6523f, 15.0f, 12.0f, 15.0f)
                curveTo(10.3477f, 15.0f, 9.0f, 13.6523f, 9.0f, 12.0f)
                curveTo(9.0f, 10.3477f, 10.3477f, 9.0f, 12.0f, 9.0f)
                close()
                moveTo(12.0f, 11.0f)
                curveTo(11.4492f, 11.0f, 11.0f, 11.4492f, 11.0f, 12.0f)
                curveTo(11.0f, 12.5508f, 11.4492f, 13.0f, 12.0f, 13.0f)
                curveTo(12.5508f, 13.0f, 13.0f, 12.5508f, 13.0f, 12.0f)
                curveTo(13.0f, 11.4492f, 12.5508f, 11.0f, 12.0f, 11.0f)
                close()
                moveTo(6.125f, 15.5625f)
                lineTo(7.0f, 20.0f)
                curveTo(7.0f, 20.0f, 8.0f, 22.0f, 12.0f, 22.0f)
                curveTo(16.0f, 22.0f, 17.0f, 20.0f, 17.0f, 20.0f)
                lineTo(17.875f, 15.5625f)
                curveTo(17.4219f, 15.8633f, 15.4766f, 17.0f, 12.0f, 17.0f)
                curveTo(8.5234f, 17.0f, 6.5781f, 15.8633f, 6.125f, 15.5625f)
                close()
            }
        }
            .build()
        return _bitbucket!!
    }

private var _bitbucket: ImageVector? = null
