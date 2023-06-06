package ru.sr.surrfit.presentation.compose.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.koin.androidx.compose.koinViewModel
import ru.sr.surrfit.base.BaseViewModel
import ru.sr.surrfit.presentation.viewmodel.RatingViewModel
import ru.sr.surrfit.theme.SurfTheme
import ru.sr.surrfit.view.Screen

@Composable
fun RatingScreen(viewModel: RatingViewModel = koinViewModel()) {

    Screen(viewModel = viewModel) {state, action, navController ->
        Text(
            text = "Привет RatingScreen",
            style = SurfTheme.fonts.h1.copy(color = SurfTheme.colors.error)
        )
    }

}