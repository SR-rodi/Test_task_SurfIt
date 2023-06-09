package ru.sr.surrfit.presentation.rating.viewmodel

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import ru.sr.surrfit.base.BaseViewModel
import ru.sr.surrfit.dispatcherwrapper.SurfDispatcher
import ru.sr.surrfit.RatingSorter
import ru.sr.surrfit.domain.usecase.GetRatingUseCase
import ru.sr.surrfit.mapper.toUi
import ru.sr.surrfit.presentation.model.RatingUiModel
import ru.sr.surrfit.presentation.rating.viewmodel.model.RatingAction
import ru.sr.surrfit.presentation.rating.viewmodel.model.RatingEvent
import ru.sr.surrfit.presentation.rating.viewmodel.model.RatingState

class RatingViewModel(
    private val getRatingUseCase: GetRatingUseCase,
    private val dispatcher: SurfDispatcher,
) : BaseViewModel<RatingState, RatingAction, RatingEvent>(RatingState()) {

    private var job = Job().job

    override fun obtainEvent(viewEvent: RatingEvent) {
        when (viewEvent) {
            is RatingEvent.OnGetRatingBySorter -> getRatings(viewEvent.sorter)
            is RatingEvent.OnSearch -> onSearch(viewEvent.query)
            RatingEvent.OnClearSearch -> onClearSearchState()
            is RatingEvent.OnClickItemRating -> onClickItem(viewEvent.ratingItem)
            RatingEvent.ResetAction -> onResetAction()
        }
    }

    private fun onClickItem(ratingItem: RatingUiModel) {
        viewAction = RatingAction.OpenDetailScreen(ratingItem)
    }

    private fun onSearch(query: String) {
        viewState = viewState.copy(search = query)
        job.cancel()
        job = scopeLaunch {
            delay(500)
            val items = viewState.items.filter { model ->
                model.userName.lowercase().contains(query.lowercase())
            }
            viewState = viewState.copy(searchItems = items)
        }
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