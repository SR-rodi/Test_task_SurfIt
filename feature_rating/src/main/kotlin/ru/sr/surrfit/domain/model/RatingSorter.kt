package ru.sr.surrfit.domain.model

import ru.sr.nineteen.feature_rating.R

enum class RatingSorter(val fieldSorter: Int) {
    ID(R.string.registration_sorter_id),
    STEP(R.string.registration_sorter_step),
    MODE(R.string.registration_sorter_mode),
    USER_NAME(R.string.registration_sorter_name),
    EMAIL(R.string.registration_sorter_email),

}