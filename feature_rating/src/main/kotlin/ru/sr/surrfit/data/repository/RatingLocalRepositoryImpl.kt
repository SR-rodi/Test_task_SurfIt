package ru.sr.surrfit.data.repository

import ru.sr.surrfit.domain.model.RatingDomainModel
import ru.sr.surrfit.domain.model.RatingSorter
import ru.sr.surrfit.domain.repository.RatingLocalRepository
import ru.sr.surrfit.local.dao.RatingDao
import ru.sr.surrfit.util.toDomain

class RatingLocalRepositoryImpl(private val ratingDao: RatingDao) : RatingLocalRepository {

    private val ratings = emptyList<RatingDomainModel>()

    override suspend fun getAllItems(sorter:String): List<RatingDomainModel> {
        return ratingDao.getAllFromSorter(sorter).map { entity -> entity.toDomain() }
    }

}