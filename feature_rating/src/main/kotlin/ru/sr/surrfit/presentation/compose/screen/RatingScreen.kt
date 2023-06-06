package ru.sr.surrfit.presentation.compose.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import ru.sr.surrfit.theme.SurfTheme

@Composable
fun RatingScreen() {
    Text(
        text = "Привет RatingScreen",
        style = SurfTheme.fonts.h1.copy(color = SurfTheme.colors.error)
    )
}