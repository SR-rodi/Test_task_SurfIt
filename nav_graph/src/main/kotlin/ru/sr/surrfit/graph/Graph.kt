package ru.sr.surrfit.graph

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.sr.surrfit.navigation.tree.NavigationTree
import ru.sr.surrfit.presentation.detail.compose.screen.DetailScreen
import ru.sr.surrfit.presentation.model.RatingUiModel
import ru.sr.surrfit.presentation.prefill.compose.PrefillScreen
import ru.sr.surrfit.presentation.rating.compose.screen.RatingScreen
import ru.sr.surrfit.theme.LocalNavigateController

fun NavGraphBuilder.setNavigate() {
    composable(NavigationTree.RatingScreen) { RatingScreen() }
    composable(NavigationTree.PrefillScreen) { PrefillScreen() }
    composable<RatingUiModel>(NavigationTree.DetailScreen) { rating -> DetailScreen(item = rating) }
}


fun <T> NavGraphBuilder.composable(
    route: NavigationTree,
    content: @Composable (value: T) -> Unit,
) {
    composable(route.name) {
        val value =
            LocalNavigateController.current.previousBackStackEntry?.savedStateHandle?.get<T>(route.key)
        if (value == null) Log.e("Kart", "не задан аргумент") else content(value)

    }
}

fun NavGraphBuilder.composable(route: NavigationTree, content: @Composable () -> Unit) {
    composable(route.name) {
        content()
    }
}