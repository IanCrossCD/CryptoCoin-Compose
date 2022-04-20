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

public val CryptoIcons.Facebook: ImageVector
    get() {
        if (_facebook != null) {
            return _facebook!!
        }
        _facebook = Builder(
            name = "Facebook", defaultWidth = 30.0.dp, defaultHeight = 30.0.dp,
            viewportWidth = 30.0f, viewportHeight = 30.0f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(15.0f, 3.0f)
                curveTo(8.373f, 3.0f, 3.0f, 8.373f, 3.0f, 15.0f)
                curveToRelative(0.0f, 6.016f, 4.432f, 10.984f, 10.206f, 11.852f)
                verticalLineTo(18.18f)
                horizontalLineToRelative(-2.969f)
                verticalLineToRelative(-3.154f)
                horizontalLineToRelative(2.969f)
                verticalLineToRelative(-2.099f)
                curveToRelative(0.0f, -3.475f, 1.693f, -5.0f, 4.581f, -5.0f)
                curveToRelative(1.383f, 0.0f, 2.115f, 0.103f, 2.461f, 0.149f)
                verticalLineToRelative(2.753f)
                horizontalLineToRelative(-1.97f)
                curveToRelative(-1.226f, 0.0f, -1.654f, 1.163f, -1.654f, 2.473f)
                verticalLineToRelative(1.724f)
                horizontalLineToRelative(3.593f)
                lineTo(19.73f, 18.18f)
                horizontalLineToRelative(-3.106f)
                verticalLineToRelative(8.697f)
                curveTo(22.481f, 26.083f, 27.0f, 21.075f, 27.0f, 15.0f)
                curveTo(27.0f, 8.373f, 21.627f, 3.0f, 15.0f, 3.0f)
                close()
            }
        }
            .build()
        return _facebook!!
    }

private var _facebook: ImageVector? = null
