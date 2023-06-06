package ru.sr.surrfit.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class SurfColor(
    val background: Color,
    val error: Color,
    val green:Color,
    val text: Color,
    val titleText:Color,
)

val lightPalette = SurfColor(
    background = Color(0xFFC4F3F3),
    text = Color(0xFF070707),
    error = Color(0xFFC00A0A),
    green  = Color(0xFF55847A),
    titleText = Color(0xFFC4F3F3)
)


val darkPalette = lightPalette.copy(background = Color(0xFF070707))

val LocalColorProvider =
    staticCompositionLocalOf<SurfColor> { error("No default implementation") }