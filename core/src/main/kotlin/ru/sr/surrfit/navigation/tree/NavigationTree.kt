package ru.sr.surrfit.navigation.tree

enum class NavigationTree(val key: String = "") {
    RatingScreen, PrefillScreen, DetailScreen("detailRating")
}