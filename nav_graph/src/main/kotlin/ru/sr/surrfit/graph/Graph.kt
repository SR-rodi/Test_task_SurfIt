package ru.sr.surrfit.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.sr.surrfit.presentation.compose.screen.RatingScreen
import ru.sr.surrfit.tree.NavigationTree

fun NavGraphBuilder.setNavigate() {
    composable(NavigationTree.RatingScreen.name) { RatingScreen() }
}