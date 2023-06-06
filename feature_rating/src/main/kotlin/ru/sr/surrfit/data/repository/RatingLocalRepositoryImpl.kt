package ru.sr.surrfit.data.repository

import ru.sr.surrfit.domain.model.RatingDomainModel
import ru.sr.surrfit.domain.repository.RatingLocalRepository
import ru.sr.surrfit.local.dao.RatingDao
import ru.sr.surrfit.mapper.toDomain
import ru.sr.surrfit.mapper.toEntity

class RatingLocalRepositoryImpl(private val ratingDao: RatingDao) : RatingLocalRepository {


    override suspend fun getAllItems(sorter: String): List<RatingDomainModel> {
        return ratingDao.getAllFromSorter(sorter).map { entity -> entity.toDomain() }
    }

    override suspend fun insertItems(items: List<RatingDomainModel>) {
        ratingDao.insert(items.map { domain -> domain.toEntity() })
    }

}