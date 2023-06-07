package ru.sr.surrfit.mapper

import com.google.gson.Gson
import ru.sr.surrfit.domain.model.RatingDomainModel
import ru.sr.surrfit.local.entity.RatingEntity
import ru.sr.surrfit.presentation.model.RatingUiModel
import ru.sr.surrfit.widjet.ListRatingWidgetModal
import ru.sr.surrfit.widjet.RatingWidgetModal

fun RatingEntity.toDomain() = RatingDomainModel(
    id ?: 0, mode, stepCount, userName, email
)

fun RatingDomainModel.toUi() = RatingUiModel(
    id, mode, stepCount, userName, email
)

fun RatingDomainModel.toEntity() = RatingEntity(
    mode, stepCount, userName, email, null
)

fun RatingEntity.toWidget() = RatingWidgetModal(
    id ?: 0, mode, stepCount, userName, email
)

fun ListRatingWidgetModal.toGson(): String {
    return Gson().toJson(this)
}

fun String?.toWidget(): ListRatingWidgetModal {
    return Gson().fromJson(this, ListRatingWidgetModal::class.java)
}
