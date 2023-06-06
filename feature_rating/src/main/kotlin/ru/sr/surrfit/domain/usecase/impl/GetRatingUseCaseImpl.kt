package ru.sr.surrfit.domain.usecase.impl

import ru.sr.surrfit.domain.model.RatingDomainModel
import ru.sr.surrfit.domain.model.RatingSorter
import ru.sr.surrfit.domain.repository.RatingLocalRepository
import ru.sr.surrfit.domain.usecase.GetRatingUseCase

class GetRatingUseCaseImpl(
    private val repository: RatingLocalRepository,
) : GetRatingUseCase {
    override suspend fun getItemsByFilter(sorter: RatingSorter): List<RatingDomainModel> {
        return repository.getAllItemsSorted(sorter)
    }
}