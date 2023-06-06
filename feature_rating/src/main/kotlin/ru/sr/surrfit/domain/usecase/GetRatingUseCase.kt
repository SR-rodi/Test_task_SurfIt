package ru.sr.surrfit.domain.usecase

import ru.sr.surrfit.domain.model.RatingDomainModel

interface GetRatingUseCase {
    suspend fun getItemsByFilter(sorter: String): List<RatingDomainModel>
}