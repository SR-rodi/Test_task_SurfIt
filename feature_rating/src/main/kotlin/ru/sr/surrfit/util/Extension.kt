package ru.sr.surrfit.util

import ru.sr.surrfit.domain.model.RatingDomainModel
import ru.sr.surrfit.local.entity.RatingEntity
import ru.sr.surrfit.presentation.model.RatingUiModel

fun RatingEntity.toDomain() = RatingDomainModel(
    id ?: 0, mode, stepCount, userName, email
)

fun RatingDomainModel.toUi() = RatingUiModel(
    id, mode, stepCount, userName, email
)