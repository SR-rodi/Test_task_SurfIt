package ru.sr.surrfit.domain.usecase

import ru.sr.surrfit.domain.model.RatingDomainModel

interface InsertRatingUseCase {
    suspend fun insertItems(items: List<RatingDomainModel>)
}