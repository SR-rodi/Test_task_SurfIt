package ru.sr.surrfit.data.repository

import ru.sr.surrfit.domain.model.RatingDomainModel
import ru.sr.surrfit.domain.repository.RatingLocalRepository
import ru.sr.surrfit.local.dao.RatingDao
import ru.sr.surrfit.util.toDomain

class RatingLocalRepositoryImpl(private val ratingDao: RatingDao) : RatingLocalRepository {

    override suspend fun getAllItems(): List<RatingDomainModel> {
        return ratingDao.getAll().map { entity -> entity.toDomain() }
    }
}