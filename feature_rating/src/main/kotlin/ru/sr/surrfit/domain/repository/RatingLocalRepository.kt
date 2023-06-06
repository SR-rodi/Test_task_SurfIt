package ru.sr.surrfit.domain.repository

import ru.sr.surrfit.domain.model.RatingDomainModel

interface RatingLocalRepository {
    suspend fun getAllItems(): List<RatingDomainModel>
}