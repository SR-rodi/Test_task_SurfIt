package ru.sr.surrfit.presentation.viewmodel

import ru.sr.surrfit.base.BaseViewModel
import ru.sr.surrfit.dispatcherwrapper.SurfDispatcher
import ru.sr.surrfit.domain.usecase.GetRatingUseCase

class RatingViewModel(
    private val getRatingUseCase: GetRatingUseCase,
    private val dispatcher: SurfDispatcher,
) : BaseViewModel<RatingState, RatingAction, RatingEvent>(RatingState()) {
    override fun obtainEvent(viewEvent: RatingEvent) {}
}

data class RatingState(val isLoading: Boolean = false)

sealed interface RatingEvent {

}

sealed interface RatingAction {

}