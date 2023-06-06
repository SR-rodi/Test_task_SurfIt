package ru.sr.surrfit.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.sr.surrfit.navigation.tree.NavigationTree
import ru.sr.surrfit.presentation.prefill.presentation.compose.PrefillScreen
import ru.sr.surrfit.presentation.rating.compose.screen.RatingScreen

fun NavGraphBuilder.setNavigate() {
    composable(NavigationTree.RatingScreen.name) { RatingScreen() }
    composable(NavigationTree.PrefillScreen.name) { PrefillScreen() }
}