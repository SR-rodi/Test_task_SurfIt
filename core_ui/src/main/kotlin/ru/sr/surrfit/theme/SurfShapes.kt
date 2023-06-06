package ru.sr.surrfit.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

data class SurfShapes(
    val small: Shape,
    val medium: Shape,
    val large: Shape,
    val dialog: Shape,
)

val shapes = SurfShapes(
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(12.dp),
    large = RoundedCornerShape(20.dp),
    dialog = RoundedCornerShape(30.dp),
)

val LocalShapeProvider =
    staticCompositionLocalOf<SurfShapes> { error("No default implementation") }