package ru.sr.surrfit.widjet

import android.content.Context
import androidx.compose.ui.unit.dp
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.currentState
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.size
import androidx.glance.text.Text
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.sr.surrfit.domain.model.RatingSorter
import ru.sr.surrfit.local.db.SurfDatabase
import ru.sr.surrfit.mapper.toWidget
import ru.sr.surrfit.widjet.view.ItemWidgetView
import ru.sr.surrfit.widjet.view.SortedWidgetView

object SurfWidget : GlanceAppWidget() {

    val currentItemsKey = stringPreferencesKey("currentList")
    val sortedListPositionKey = intPreferencesKey("currentPosition")

    override suspend fun provideGlance(context: Context, id: GlanceId) {

        val startItems = getRatingUserInfoWidget(context, RatingSorter.ID)

        provideContent {
            val items = currentState(key = currentItemsKey)?.toWidget() ?: startItems
            val sortedPositions = currentState(key = sortedListPositionKey) ?: 0
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row {
                    Spacer(GlanceModifier.size(6.dp))
                    SortedWidgetView(sortedPositions)
                    Spacer(GlanceModifier.size(6.dp))
                    ItemWidgetView(items)
                }
            }
        }
    }
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