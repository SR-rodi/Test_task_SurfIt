package ru.sr.surfit.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ListRatingWidgetModal(
    val items :List<RatingWidgetModal> = emptyList()
): Parcelable