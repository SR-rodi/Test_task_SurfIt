package ru.sr.surrfit.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun SurfTheme(
    isNightMode: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    MaterialTheme() {
        val colors = if (isNightMode) darkPalette else lightPalette
        CompositionLocalProvider(
            LocalColorProvider provides colors,
            LocalFontProvider provides fonts,
            LocalShapeProvider provides shapes,
            LocalNavigateController provides rememberNavController(),
            content = content
        )
    }
}

val LocalNavigateController = compositionLocalOf<NavHostController> {
    error("No root controller provider")
}

object SurfTheme {
    val colors: SurfColor
        @Composable
        get() = LocalColorProvider.current
    val shapes: SurfShapes
        @Composable
        get() = LocalShapeProvider.current
    val fonts: SurfFont
        @Composable
        get() = LocalFontProvider.current
}