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

public val CryptoIcons.Reddit: ImageVector
    get() {
        if (_reddit != null) {
            return _reddit!!
        }
        _reddit = Builder(
            name = "Reddit", defaultWidth = 30.0.dp, defaultHeight = 30.0.dp,
            viewportWidth = 30.0f, viewportHeight = 30.0f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(17.6621f, 2.0f)
                curveTo(15.565f, 2.0f, 14.0f, 3.7131f, 14.0f, 5.6621f)
                lineTo(14.0f, 9.0352f)
                curveTo(11.2497f, 9.1811f, 8.7345f, 9.9144f, 6.7266f, 11.0645f)
                curveTo(5.9528f, 10.3214f, 4.9167f, 9.9914f, 3.9121f, 9.9922f)
                curveTo(2.8229f, 9.993f, 1.7095f, 10.3704f, 0.9414f, 11.2344f)
                lineTo(0.9238f, 11.2539f)
                lineTo(0.9063f, 11.2734f)
                curveTo(0.1695f, 12.1942f, -0.1223f, 13.4277f, 0.0742f, 14.6523f)
                curveTo(0.2537f, 15.7707f, 0.9014f, 16.8934f, 2.0273f, 17.6289f)
                curveTo(2.02f, 17.7531f, 2.0f, 17.8746f, 2.0f, 18.0f)
                curveTo(2.0f, 22.962f, 7.832f, 27.0f, 15.0f, 27.0f)
                curveTo(22.168f, 27.0f, 28.0f, 22.962f, 28.0f, 18.0f)
                curveTo(28.0f, 17.8746f, 27.98f, 17.7531f, 27.9727f, 17.6289f)
                curveTo(29.0986f, 16.8934f, 29.7463f, 15.7707f, 29.9258f, 14.6523f)
                curveTo(30.1223f, 13.4277f, 29.8305f, 12.1942f, 29.0938f, 11.2734f)
                lineTo(29.0762f, 11.2539f)
                lineTo(29.0586f, 11.2344f)
                curveTo(28.2904f, 10.3703f, 27.1772f, 9.993f, 26.0879f, 9.9922f)
                curveTo(25.0832f, 9.9914f, 24.047f, 10.3211f, 23.2734f, 11.0645f)
                curveTo(21.2655f, 9.9144f, 18.7503f, 9.1811f, 16.0f, 9.0352f)
                lineTo(16.0f, 5.6621f)
                curveTo(16.0f, 4.6831f, 16.5652f, 4.0f, 17.6621f, 4.0f)
                curveTo(18.1828f, 4.0f, 18.8171f, 4.2609f, 19.8105f, 4.6094f)
                curveTo(20.6504f, 4.904f, 21.7433f, 5.2017f, 23.1406f, 5.291f)
                curveTo(23.4749f, 6.2791f, 24.4028f, 7.0f, 25.5f, 7.0f)
                curveTo(26.875f, 7.0f, 28.0f, 5.875f, 28.0f, 4.5f)
                curveTo(28.0f, 3.125f, 26.875f, 2.0f, 25.5f, 2.0f)
                curveTo(24.5612f, 2.0f, 23.7475f, 2.5304f, 23.3203f, 3.3008f)
                curveTo(22.1258f, 3.2346f, 21.2482f, 2.9947f, 20.4727f, 2.7227f)
                curveTo(19.5688f, 2.4056f, 18.7384f, 2.0f, 17.6621f, 2.0f)
                close()
                moveTo(3.9121f, 11.9922f)
                curveTo(4.3072f, 11.9919f, 4.6827f, 12.0956f, 4.9922f, 12.2637f)
                curveTo(3.8882f, 13.1852f, 3.0506f, 14.2618f, 2.5449f, 15.4375f)
                curveTo(2.2764f, 15.1061f, 2.1146f, 14.734f, 2.0508f, 14.3359f)
                curveTo(1.943f, 13.6642f, 2.144f, 12.966f, 2.4629f, 12.5527f)
                curveTo(2.7642f, 12.2284f, 3.3145f, 11.9926f, 3.9121f, 11.9922f)
                close()
                moveTo(26.0859f, 11.9922f)
                curveTo(26.6838f, 11.9926f, 27.2359f, 12.2285f, 27.5371f, 12.5527f)
                curveTo(27.856f, 12.966f, 28.057f, 13.6642f, 27.9492f, 14.3359f)
                curveTo(27.8854f, 14.734f, 27.7236f, 15.1061f, 27.4551f, 15.4375f)
                curveTo(26.9494f, 14.2618f, 26.1118f, 13.1852f, 25.0078f, 12.2637f)
                curveTo(25.3166f, 12.0958f, 25.691f, 11.9919f, 26.0859f, 11.9922f)
                close()
                moveTo(10.0f, 14.0f)
                curveTo(11.105f, 14.0f, 12.0f, 14.895f, 12.0f, 16.0f)
                curveTo(12.0f, 17.105f, 11.105f, 18.0f, 10.0f, 18.0f)
                curveTo(8.895f, 18.0f, 8.0f, 17.105f, 8.0f, 16.0f)
                curveTo(8.0f, 14.895f, 8.895f, 14.0f, 10.0f, 14.0f)
                close()
                moveTo(20.0f, 14.0f)
                curveTo(21.105f, 14.0f, 22.0f, 14.895f, 22.0f, 16.0f)
                curveTo(22.0f, 17.105f, 21.105f, 18.0f, 20.0f, 18.0f)
                curveTo(18.895f, 18.0f, 18.0f, 17.105f, 18.0f, 16.0f)
                curveTo(18.0f, 14.895f, 18.895f, 14.0f, 20.0f, 14.0f)
                close()
                moveTo(20.2383f, 19.5332f)
                curveTo(19.5993f, 21.4002f, 17.556f, 23.0f, 15.0f, 23.0f)
                curveTo(12.444f, 23.0f, 10.4007f, 21.401f, 9.7617f, 19.668f)
                curveTo(10.9117f, 20.601f, 12.828f, 21.2676f, 15.0f, 21.2676f)
                curveTo(17.172f, 21.2676f, 19.0883f, 20.6002f, 20.2383f, 19.5332f)
                close()
            }
        }
            .build()
        return _reddit!!
    }

private var _reddit: ImageVector? = null
