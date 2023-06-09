package ru.sr.surrfit.presentation.rating.compose.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.koinViewModel
import ru.sr.surrfit.RatingSorter
import ru.sr.surrfit.navigation.push
import ru.sr.surrfit.navigation.tree.NavigationTree
import ru.sr.surrfit.presentation.rating.compose.view.RatingView
import ru.sr.surrfit.presentation.rating.viewmodel.model.RatingAction
import ru.sr.surrfit.presentation.rating.viewmodel.model.RatingEvent
import ru.sr.surrfit.presentation.rating.viewmodel.RatingViewModel
import ru.sr.surrfit.view.Screen

@Composable
fun RatingScreen(viewModel: RatingViewModel = koinViewModel()) {

    LaunchedEffect(key1 = true) {
        viewModel.obtainEvent(RatingEvent.OnGetRatingBySorter(RatingSorter.ID))
    }

    Screen(viewModel = viewModel) { state, action, navController ->
        Column(modifier = Modifier.fillMaxSize()) {
            RatingView(state) { ratingEvent -> viewModel.obtainEvent(ratingEvent) }

            when (action) {
                is RatingAction.OpenDetailScreen -> {
                    navController.push(NavigationTree.DetailScreen, params = action.ratingItem)
                    viewModel.obtainEvent(RatingEvent.ResetAction)
                }

                null -> {}
            }
        }
    }
}