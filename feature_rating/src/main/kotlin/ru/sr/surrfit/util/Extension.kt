package ru.sr.surrfit.util

import ru.sr.surrfit.domain.model.RatingDomainModel
import ru.sr.surrfit.local.entity.RatingEntity

fun RatingEntity.toDomain() = RatingDomainModel(
    id ?: 0, mode, stepCount, userName, email
)