package ru.sr.surrfit.presentation.prefill.compose

import androidx.compose.runtime.Composable
import org.koin.androidx.compose.koinViewModel
import ru.sr.surrfit.navigation.LaunchFlag
import ru.sr.surrfit.navigation.push
import ru.sr.surrfit.navigation.tree.NavigationTree
import ru.sr.surrfit.presentation.prefill.viewmodel.model.PrefillAction
import ru.sr.surrfit.presentation.prefill.viewmodel.PrefillViewModel
import ru.sr.surrfit.view.Screen

@Composable
fun PrefillScreen(viewModel: PrefillViewModel = koinViewModel()) {
    Screen(viewModel = viewModel) { _, action, navController ->
        when (action) {
            PrefillAction.OpenRatingScreen ->
                navController.push(NavigationTree.RatingScreen, LaunchFlag.ClearPrevious)

            null -> {}
        }
    }
}