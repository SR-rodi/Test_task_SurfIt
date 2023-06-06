package ru.sr.surrfit.presentation.prefill.presentation.viewmodel

import ru.sr.surrfit.base.BaseViewModel
import ru.sr.surrfit.dispatcherwrapper.SurfDispatcher
import ru.sr.surrfit.domain.usecase.InsertRatingUseCase
import ru.sr.surrfit.local.ItemsGeneration
import ru.sr.surrfit.mapper.toDomain

class PrefillViewModel(
    private val insertRatingUseCase: InsertRatingUseCase,
    private val dispatcher: SurfDispatcher,
) : BaseViewModel<Any, PrefillAction, Any>(Any()) {

    init {
        insertItems()
    }

    override fun obtainEvent(viewEvent: Any) {}

    private fun insertItems(counter: Int = 20) = scopeLaunch(context = dispatcher.io) {

        insertRatingUseCase
            .insertItems(ItemsGeneration.getItems(counter).map { entity -> entity.toDomain() })
        viewAction = PrefillAction.OpenRatingScreen
    }
}


sealed interface PrefillAction {
    object OpenRatingScreen : PrefillAction
}
