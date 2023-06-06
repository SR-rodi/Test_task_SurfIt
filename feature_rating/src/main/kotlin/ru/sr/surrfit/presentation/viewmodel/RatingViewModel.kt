package ru.sr.surrfit.presentation.viewmodel

import android.util.Log
import ru.sr.surrfit.base.BaseViewModel
import ru.sr.surrfit.domain.model.RatingSorter
import ru.sr.surrfit.dispatcherwrapper.SurfDispatcher
import ru.sr.surrfit.domain.usecase.GetRatingUseCase
import ru.sr.surrfit.presentation.model.RatingUiModel
import ru.sr.surrfit.util.toUi

class RatingViewModel(
    private val getRatingUseCase: GetRatingUseCase,
    private val dispatcher: SurfDispatcher,
) : BaseViewModel<RatingState, RatingAction, RatingEvent>(RatingState()) {

    override fun obtainEvent(viewEvent: RatingEvent) {
        when (viewEvent) {
            is RatingEvent.OnGetRatingByFilter -> getRatings(viewEvent.filter)
            is RatingEvent.OnSearchInDatabase -> {}
        }
    }

    private fun getRatings(sorter: RatingSorter) = scopeLaunch(context = dispatcher.io) {
        viewState = viewState.copy(isLoading = true)

        val ratingItems = getRatingUseCase.getItemsByFilter(sorter.fieldSorter).map { domain -> domain.toUi() }
        Log.e("kart",ratingItems.toString())
        viewState = viewState.copy(isLoading = false, items = ratingItems)
    }
}

data class RatingState(
    val isLoading: Boolean = false,
    val items: List<RatingUiModel> = emptyList(),
)

sealed interface RatingEvent {
    class OnGetRatingByFilter(val filter: RatingSorter) : RatingEvent
    class OnSearchInDatabase(val query: String) : RatingEvent
}

sealed interface RatingAction {

}