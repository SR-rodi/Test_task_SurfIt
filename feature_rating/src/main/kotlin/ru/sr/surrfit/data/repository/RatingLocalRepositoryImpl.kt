package ru.sr.surrfit.data.repository

import ru.sr.surrfit.domain.model.RatingDomainModel
import ru.sr.surrfit.RatingSorter
import ru.sr.surrfit.domain.repository.RatingLocalRepository
import ru.sr.surrfit.local.dao.RatingDao
import ru.sr.surrfit.mapper.toDomain
import ru.sr.surrfit.mapper.toEntity

class RatingLocalRepositoryImpl(private val ratingDao: RatingDao) : RatingLocalRepository {

    override suspend fun getAllItemsSorted(sorter: RatingSorter): List<RatingDomainModel> {
        return when (sorter) {
            RatingSorter.MODE -> ratingDao.getAllSortedByMode()
            RatingSorter.STEP -> ratingDao.getAllSortedByStep()
            RatingSorter.USER_NAME -> ratingDao.getAllSortedByName()
            RatingSorter.EMAIL -> ratingDao.getAllSortedByEmail()
            RatingSorter.ID -> ratingDao.getAllSortedById()
        }.map { entity -> entity.toDomain() }
    }

    override suspend fun insertItems(items: List<RatingDomainModel>) {
        ratingDao.insert(items.map { domain -> domain.toEntity() })
    }
}