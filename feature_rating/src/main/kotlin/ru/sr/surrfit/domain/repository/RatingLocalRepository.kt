package ru.sr.surrfit.domain.repository

import ru.sr.surrfit.domain.model.RatingDomainModel
import ru.sr.surrfit.RatingSorter

interface RatingLocalRepository {
    suspend fun getAllItemsSorted(sorter: RatingSorter): List<RatingDomainModel>

    suspend fun insertItems(items: List<RatingDomainModel>)
}