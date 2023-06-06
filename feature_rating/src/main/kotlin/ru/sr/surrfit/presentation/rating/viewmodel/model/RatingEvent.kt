package ru.sr.surrfit.presentation.rating.viewmodel.model

import ru.sr.surrfit.domain.model.RatingSorter
import ru.sr.surrfit.presentation.model.RatingUiModel

sealed interface RatingEvent {
    object OnClearSearch : RatingEvent
    object ResetAction : RatingEvent
    class OnGetRatingBySorter(val sorter: RatingSorter) : RatingEvent
    class OnSearch(val query: String) : RatingEvent
    class OnClickItemRating(val ratingItem: RatingUiModel) : RatingEvent
}