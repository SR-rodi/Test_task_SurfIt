package ru.sr.surrfit.domain.usecase.impl

import ru.sr.surrfit.domain.model.RatingDomainModel
import ru.sr.surrfit.domain.repository.RatingLocalRepository
import ru.sr.surrfit.domain.usecase.InsertRatingUseCase
import ru.sr.surrfit.firstrunlistener.FirstRunListener

class InsertRatingUseCaseImpl(
    private val repository: RatingLocalRepository,
    private val firstRunListener: FirstRunListener,
) : InsertRatingUseCase {
    override suspend fun insertItems(items: List<RatingDomainModel>) {
        repository.insertItems(items)
        firstRunListener.putFirstRun()
    }
}