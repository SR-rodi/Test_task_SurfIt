package ru.sr.surrfit.presentation.rating.viewmodel.model

import ru.sr.surrfit.presentation.model.RatingUiModel

sealed interface RatingAction {
    class OpenDetailScreen(val ratingItem: RatingUiModel) : RatingAction
}