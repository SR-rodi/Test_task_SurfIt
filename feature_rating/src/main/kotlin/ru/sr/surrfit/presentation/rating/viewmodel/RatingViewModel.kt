package ru.sr.surrfit.presentation.rating.viewmodel

import ru.sr.surrfit.base.BaseViewModel
import ru.sr.surrfit.dispatcherwrapper.SurfDispatcher
import ru.sr.surrfit.domain.model.RatingSorter
import ru.sr.surrfit.domain.usecase.GetRatingUseCase
import ru.sr.surrfit.mapper.toUi
import ru.sr.surrfit.presentation.rating.model.RatingUiModel

class RatingViewModel(
    private val getRatingUseCase: GetRatingUseCase,
    private val dispatcher: SurfDispatcher,
) : BaseViewModel<RatingState, RatingAction, RatingEvent>(RatingState()) {

    override fun obtainEvent(viewEvent: RatingEvent) {
        when (viewEvent) {
            is RatingEvent.OnGetRatingBySorter -> getRatings(viewEvent.sorter)
            is RatingEvent.OnSearch -> onSearch(viewEvent.query)
            RatingEvent.OnClearSearch -> onClearSearchState()
        }
    }

    private fun onSearch(query: String) {
        viewState = viewState.copy(
            search = query,
            searchItems = viewState.items.filter { it.userName == query })
    }

    private fun onClearSearchState() {
        viewState = viewState.copy(search = "")
    }

    private fun getRatings(sorter: RatingSorter) = scopeLaunch(context = dispatcher.io) {
        viewState = viewState.copy(isLoading = true)
        val ratingItems = getRatingUseCase.getItemsByFilter(sorter).map { domain -> domain.toUi() }
        viewState = viewState.copy(isLoading = false, items = ratingItems)
    }
}

data class RatingState(
    val isLoading: Boolean = false,
    val items: List<RatingUiModel> = emptyList(),
    val search: String = "",
    val searchItems: List<RatingUiModel> = emptyList(),
)

sealed interface RatingEvent {
    object OnClearSearch : RatingEvent
    class OnGetRatingBySorter(val sorter: RatingSorter) : RatingEvent
    class OnSearch(val query: String) : RatingEvent
}

sealed interface RatingAction {

}