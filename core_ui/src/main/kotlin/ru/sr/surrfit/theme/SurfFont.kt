package ru.sr.surrfit.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

class SurfFont(
    val h1: TextStyle = baseFontStyle(textSize = 48.sp, weight = FontWeight.ExtraBold),
    val h2: TextStyle = baseFontStyle(textSize = 32.sp, weight = FontWeight.Normal),
    val h3: TextStyle = baseFontStyle(textSize = 24.sp, weight = FontWeight.SemiBold),
    val h4: TextStyle = baseFontStyle(textSize = 16.sp, weight = FontWeight.Normal),
    val p: TextStyle = baseFontStyle(textSize = 14.sp, weight = FontWeight.Light),
)

private fun baseFontStyle(textSize: TextUnit, weight: FontWeight) = TextStyle(
    fontSize = textSize,
    fontWeight = weight,
)

val fonts = SurfFont()

val LocalFontProvider =
    staticCompositionLocalOf<SurfFont> { error("No default implementation") }