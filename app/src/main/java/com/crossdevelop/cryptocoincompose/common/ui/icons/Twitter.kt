package com.crossdevelop.cryptocoincompose.common.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.crossdevelop.cryptocoincompose.common.ui.CryptoIcons

public val CryptoIcons.Twitter: ImageVector
    get() {
        if (_twitter != null) {
            return _twitter!!
        }
        _twitter = ImageVector.Builder(
            name = "Twitter", defaultWidth = 30.0.dp, defaultHeight = 30.0.dp,
            viewportWidth = 30.0f, viewportHeight = 30.0f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(28.0f, 6.937f)
                curveToRelative(-0.957f, 0.425f, -1.985f, 0.711f, -3.064f, 0.84f)
                curveToRelative(1.102f, -0.66f, 1.947f, -1.705f, 2.345f, -2.951f)
                curveToRelative(-1.03f, 0.611f, -2.172f, 1.055f, -3.388f, 1.295f)
                curveToRelative(-0.973f, -1.037f, -2.359f, -1.685f, -3.893f, -1.685f)
                curveToRelative(-2.946f, 0.0f, -5.334f, 2.389f, -5.334f, 5.334f)
                curveToRelative(0.0f, 0.418f, 0.048f, 0.826f, 0.138f, 1.215f)
                curveToRelative(-4.433f, -0.222f, -8.363f, -2.346f, -10.995f, -5.574f)
                curveTo(3.351f, 6.199f, 3.088f, 7.115f, 3.088f, 8.094f)
                curveToRelative(0.0f, 1.85f, 0.941f, 3.483f, 2.372f, 4.439f)
                curveToRelative(-0.874f, -0.028f, -1.697f, -0.268f, -2.416f, -0.667f)
                curveToRelative(0.0f, 0.023f, 0.0f, 0.044f, 0.0f, 0.067f)
                curveToRelative(0.0f, 2.585f, 1.838f, 4.741f, 4.279f, 5.23f)
                curveToRelative(-0.447f, 0.122f, -0.919f, 0.187f, -1.406f, 0.187f)
                curveToRelative(-0.343f, 0.0f, -0.678f, -0.034f, -1.003f, -0.095f)
                curveToRelative(0.679f, 2.119f, 2.649f, 3.662f, 4.983f, 3.705f)
                curveToRelative(-1.825f, 1.431f, -4.125f, 2.284f, -6.625f, 2.284f)
                curveToRelative(-0.43f, 0.0f, -0.855f, -0.025f, -1.273f, -0.075f)
                curveToRelative(2.361f, 1.513f, 5.164f, 2.396f, 8.177f, 2.396f)
                curveToRelative(9.812f, 0.0f, 15.176f, -8.128f, 15.176f, -15.177f)
                curveToRelative(0.0f, -0.231f, -0.005f, -0.461f, -0.015f, -0.69f)
                curveTo(26.38f, 8.945f, 27.285f, 8.006f, 28.0f, 6.937f)
                close()
            }
        }
            .build()
        return _twitter!!
    }

private var _twitter: ImageVector? = null
