package ru.sr.surrfit.presentation.rating.compose.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import org.koin.androidx.compose.koinViewModel
import ru.sr.surrfit.base.BaseViewModel
import ru.sr.surrfit.domain.model.RatingSorter
import ru.sr.surrfit.presentation.rating.viewmodel.RatingEvent
import ru.sr.surrfit.presentation.rating.viewmodel.RatingViewModel
import ru.sr.surrfit.theme.SurfTheme
import ru.sr.surrfit.view.Screen

@Composable
fun RatingScreen(viewModel: RatingViewModel = koinViewModel()) {

    LaunchedEffect(key1 = true){
        viewModel.obtainEvent(RatingEvent.OnGetRatingByFilter(RatingSorter.MODE))
    }

    Screen(viewModel = viewModel) {state, action, navController ->
        Text(
            text = "Привет RatingScreen",
            style = SurfTheme.fonts.h1.copy(color = SurfTheme.colors.error)
        )
    }

}