package ru.sr.surrfit.domain.usecase

import ru.sr.surrfit.domain.model.RatingDomainModel
import ru.sr.surrfit.RatingSorter

interface GetRatingUseCase {
    suspend fun getItemsByFilter(sorter: RatingSorter): List<RatingDomainModel>
}