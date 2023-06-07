package ru.sr.surrfit.widjet

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RatingWidgetModal(
    val id: Int,
    val mode: String,
    val stepCount: Int,
    val userName: String,
    val email: String,
):Parcelable

@Parcelize
data class ListRatingWidgetModal(
    val items :List<RatingWidgetModal> = emptyList()
):Parcelable


