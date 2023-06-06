package ru.sr.surrfit.domain.model

enum class RatingSorter(val fieldSorter: String) {
    MODE("mode"),
    STEP("stepCount"),
    USER_NAME("name"),
    EMAIL("email")
}