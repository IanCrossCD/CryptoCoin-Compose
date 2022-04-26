package com.crossdevelop.cryptocoincompose.common.ui.theme

import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = CutCornerShape(4.dp),
    medium = CutCornerShape(6.dp),
    large = CutCornerShape(8.dp),
)

val ObtuseShape = GenericShape { size, _ ->
    moveTo(0f, size.height * .3f)
    lineTo(size.width * .15f, size.height)
    lineTo(size.width, size.height)
    lineTo(size.width, size.height * .7f)
    lineTo(size.width * .85f, 0f)
    lineTo(0f, 0f)
}

val OffsetRoundedCornersShape = RoundedCornerShape(topStart = 0.dp, bottomStart = 24.dp, topEnd = 24.dp, bottomEnd = 0.dp)