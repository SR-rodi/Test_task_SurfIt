package ru.sr.surrfit.domain.repository

import ru.sr.surrfit.domain.model.RatingDomainModel
import java.time.temporal.TemporalQuery

interface RatingLocalRepository {
    suspend fun getAllItems(sorter:String): List<RatingDomainModel>

}