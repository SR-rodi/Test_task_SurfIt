package ru.sr.surrfit.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder
import ru.sr.surrfit.navigation.tree.NavigationTree

internal fun NavOptionsBuilder.setPopUp(destination: String?, launchFlag: LaunchFlag) {
    destination?:return
        when (launchFlag) {
            LaunchFlag.SimpleNavigation -> {}

            LaunchFlag.ClearPrevious -> {
                popUpTo(destination) {
                    this.inclusive = true
                }
            }
            LaunchFlag.ClearNavGraph ->  popUpTo(0)
        }
}


fun <I> NavController.push(
    route: NavigationTree,
    params: I,
    launchFlag: LaunchFlag = LaunchFlag.SimpleNavigation,
) {
    currentBackStackEntry?.savedStateHandle?.set(
        key = route.key,
        value = params,
    )
    navigate(route.name) {
        setPopUp(currentDestination?.route, launchFlag)
    }
}

fun NavController.push(
    route: NavigationTree,
    launchFlag: LaunchFlag = LaunchFlag.SimpleNavigation,
) {
    navigate(route.name) {
        setPopUp(currentDestination?.route, launchFlag)
    }
}


sealed interface LaunchFlag {
    object SimpleNavigation : LaunchFlag
    object ClearPrevious : LaunchFlag
    object ClearNavGraph : LaunchFlag
}