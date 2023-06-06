package ru.sr.surrfit.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class RatingUiModel(
    val id: Int,
    val mode: String,
    val stepCount: Int,
    val userName: String,
    val email: String,
) : Parcelable