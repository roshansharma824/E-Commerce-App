package com.example.tummocandroidassignment.ui.presentation.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

@Composable
fun rememberCheckIndeterminateSmall(): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "check_indeterminate_small",
            defaultWidth = 40.0.dp,
            defaultHeight = 40.0.dp,
            viewportWidth = 40.0f,
            viewportHeight = 40.0f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1f,
                stroke = null,
                strokeAlpha = 1f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(13.042f, 21.292f)
                quadToRelative(-0.542f, 0f, -0.917f, -0.375f)
                reflectiveQuadTo(11.75f, 20f)
                quadToRelative(0f, -0.542f, 0.375f, -0.938f)
                quadToRelative(0.375f, -0.395f, 0.917f, -0.395f)
                horizontalLineToRelative(13.916f)
                quadToRelative(0.542f, 0f, 0.938f, 0.395f)
                quadToRelative(0.396f, 0.396f, 0.396f, 0.938f)
                quadToRelative(0f, 0.542f, -0.396f, 0.917f)
                reflectiveQuadToRelative(-0.938f, 0.375f)
                close()
            }
        }.build()
    }
}