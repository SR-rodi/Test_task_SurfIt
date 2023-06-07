package ru.sr.surfit.mapper

import android.content.Context
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.sr.surfit.data.ListRatingWidgetModal
import ru.sr.surfit.data.RatingWidgetModal
import ru.sr.surrfit.RatingSorter
import ru.sr.surrfit.local.db.SurfDatabase
import ru.sr.surrfit.local.entity.RatingEntity


fun RatingEntity.toWidget() = RatingWidgetModal(
    id ?: 0, mode, stepCount, userName, email
)

fun ListRatingWidgetModal.toGson(): String {
    return Gson().toJson(this)
}

fun String?.toWidget(): ListRatingWidgetModal {
    return Gson().fromJson(this, ListRatingWidgetModal::class.java)
}


suspend fun getRatingUserInfoWidget(
    context: Context,
    sorter: RatingSorter,
): ListRatingWidgetModal {
    val dao = SurfDatabase.getInstance(context).ratingDao()
    val newList =  withContext(Dispatchers.IO) {
        when (sorter) {
            RatingSorter.ID -> dao.getAllSortedById()
            RatingSorter.STEP -> dao.getAllSortedByStep()
            RatingSorter.MODE -> dao.getAllSortedByMode()
            RatingSorter.USER_NAME -> dao.getAllSortedByName()
            RatingSorter.EMAIL -> dao.getAllSortedByEmail()
        }.take(3).map { ratingEntity -> ratingEntity.toWidget() }
    }
    return ListRatingWidgetModal(newList)
}