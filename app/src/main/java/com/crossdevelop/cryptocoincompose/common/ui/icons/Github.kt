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

public val CryptoIcons.Github: ImageVector
    get() {
        if (_github != null) {
            return _github!!
        }
        _github = Builder(
            name = "Github", defaultWidth = 30.0.dp, defaultHeight = 30.0.dp,
            viewportWidth = 30.0f, viewportHeight = 30.0f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(15.0f, 3.0f)
                curveTo(8.373f, 3.0f, 3.0f, 8.373f, 3.0f, 15.0f)
                curveToRelative(0.0f, 5.623f, 3.872f, 10.328f, 9.092f, 11.63f)
                curveTo(12.036f, 26.468f, 12.0f, 26.28f, 12.0f, 26.047f)
                verticalLineToRelative(-2.051f)
                curveToRelative(-0.487f, 0.0f, -1.303f, 0.0f, -1.508f, 0.0f)
                curveToRelative(-0.821f, 0.0f, -1.551f, -0.353f, -1.905f, -1.009f)
                curveToRelative(-0.393f, -0.729f, -0.461f, -1.844f, -1.435f, -2.526f)
                curveToRelative(-0.289f, -0.227f, -0.069f, -0.486f, 0.264f, -0.451f)
                curveToRelative(0.615f, 0.174f, 1.125f, 0.596f, 1.605f, 1.222f)
                curveToRelative(0.478f, 0.627f, 0.703f, 0.769f, 1.596f, 0.769f)
                curveToRelative(0.433f, 0.0f, 1.081f, -0.025f, 1.691f, -0.121f)
                curveToRelative(0.328f, -0.833f, 0.895f, -1.6f, 1.588f, -1.962f)
                curveToRelative(-3.996f, -0.411f, -5.903f, -2.399f, -5.903f, -5.098f)
                curveToRelative(0.0f, -1.162f, 0.495f, -2.286f, 1.336f, -3.233f)
                curveTo(9.053f, 10.647f, 8.706f, 8.73f, 9.435f, 8.0f)
                curveToRelative(1.798f, 0.0f, 2.885f, 1.166f, 3.146f, 1.481f)
                curveTo(13.477f, 9.174f, 14.461f, 9.0f, 15.495f, 9.0f)
                curveToRelative(1.036f, 0.0f, 2.024f, 0.174f, 2.922f, 0.483f)
                curveTo(18.675f, 9.17f, 19.763f, 8.0f, 21.565f, 8.0f)
                curveToRelative(0.732f, 0.731f, 0.381f, 2.656f, 0.102f, 3.594f)
                curveToRelative(0.836f, 0.945f, 1.328f, 2.066f, 1.328f, 3.226f)
                curveToRelative(0.0f, 2.697f, -1.904f, 4.684f, -5.894f, 5.097f)
                curveTo(18.199f, 20.49f, 19.0f, 22.1f, 19.0f, 23.313f)
                verticalLineToRelative(2.734f)
                curveToRelative(0.0f, 0.104f, -0.023f, 0.179f, -0.035f, 0.268f)
                curveTo(23.641f, 24.676f, 27.0f, 20.236f, 27.0f, 15.0f)
                curveTo(27.0f, 8.373f, 21.627f, 3.0f, 15.0f, 3.0f)
                close()
            }
        }
            .build()
        return _github!!
    }

private var _github: ImageVector? = null
