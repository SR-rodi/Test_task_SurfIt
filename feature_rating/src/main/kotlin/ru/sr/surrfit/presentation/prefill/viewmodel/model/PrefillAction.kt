package ru.sr.surrfit.presentation.prefill.viewmodel.model

sealed interface PrefillAction {
    object OpenRatingScreen : PrefillAction
}