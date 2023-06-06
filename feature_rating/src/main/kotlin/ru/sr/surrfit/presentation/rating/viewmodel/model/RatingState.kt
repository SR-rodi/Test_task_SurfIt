package ru.sr.surrfit.presentation.rating.viewmodel.model

import ru.sr.surrfit.presentation.model.RatingUiModel

data class RatingState(
    val isLoading: Boolean = false,
    val items: List<RatingUiModel> = emptyList(),
    val search: String = "",
    val searchItems: List<RatingUiModel> = emptyList(),
)