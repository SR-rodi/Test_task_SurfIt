package ru.sr.surrfit.domain.usecase

import ru.sr.surrfit.domain.model.RatingDomainModel

interface GetRatingUseCase {
    suspend fun getItemsByFilter(filter: String): List<RatingDomainModel>
}