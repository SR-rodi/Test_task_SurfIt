package ru.sr.surfit.presentation.widget

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
import androidx.glance.layout.size
import ru.sr.surfit.mapper.getRatingUserInfoWidget
import ru.sr.surfit.mapper.toWidget
import ru.sr.surfit.presentation.view.ItemWidgetView
import ru.sr.surfit.presentation.view.SortedWidgetView
import ru.sr.surrfit.RatingSorter

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