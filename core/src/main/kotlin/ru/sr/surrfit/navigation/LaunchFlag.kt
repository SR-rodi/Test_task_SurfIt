package ru.sr.surrfit.navigation

sealed interface LaunchFlag {
    object SimpleNavigation : LaunchFlag
    object ClearPrevious : LaunchFlag
    object ClearNavGraph : LaunchFlag
}