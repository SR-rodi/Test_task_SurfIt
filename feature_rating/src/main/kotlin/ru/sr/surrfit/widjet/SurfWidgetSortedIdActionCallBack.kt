package ru.sr.surrfit.widjet

import android.content.Context
import android.util.Log
import androidx.glance.GlanceId
import androidx.glance.action.ActionParameters
import androidx.glance.appwidget.action.ActionCallback
import androidx.glance.appwidget.state.updateAppWidgetState
import ru.sr.surrfit.domain.model.RatingSorter
import ru.sr.surrfit.mapper.toGson

/*class SurfWidgetActionCallBack : ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters,
    ) {
        updateAppWidgetState(context, glanceId) { prefs ->

            val currentPosition = prefs[SurfWidget.sortedListPositionKey]
            if (currentPosition == null) {
                prefs[SurfWidget.sortedListPositionKey] = 0
            } else prefs[SurfWidget.sortedListPositionKey] = 3
            SurfWidget.update(context, glanceId)
        }
    }
}*/

class SurfWidgetSortedIdActionCallBack : ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters,
    ) {
        updateAppWidgetState(context, glanceId) { prefs ->
            prefs[SurfWidget.sortedListPositionKey] = RatingSorter.ID.ordinal
            val newItems = getRatingUserInfoWidget(context, RatingSorter.ID)
            prefs[SurfWidget.currentItemsKey] = newItems.toGson()
        }
        SurfWidget.update(context, glanceId)
    }
}

class SurfWidgetSortedStepActionCallBack : ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters,
    ) {
        Log.e("Kart","StartSorted")
        updateAppWidgetState(context, glanceId) { prefs ->
            prefs[SurfWidget.sortedListPositionKey] = 1
            val newItems = getRatingUserInfoWidget(context, RatingSorter.STEP)
            prefs[SurfWidget.currentItemsKey] = newItems.toGson()
        }
        SurfWidget.update(context, glanceId)
    }
}

class SurfWidgetSortedModeActionCallBack : ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters,
    ) {
        updateAppWidgetState(context, glanceId) { prefs ->
            prefs[SurfWidget.sortedListPositionKey] = RatingSorter.MODE.ordinal
            val newItems = getRatingUserInfoWidget(context, RatingSorter.MODE)
            prefs[SurfWidget.currentItemsKey] = newItems.toGson()
        }
        SurfWidget.update(context, glanceId)
    }
}

class SurfWidgetSortedNameActionCallBack : ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters,
    ) {
        updateAppWidgetState(context, glanceId) { prefs ->
            prefs[SurfWidget.sortedListPositionKey] = RatingSorter.USER_NAME.ordinal
            val newItems = getRatingUserInfoWidget(context, RatingSorter.USER_NAME)
            prefs[SurfWidget.currentItemsKey] = newItems.toGson()
        }
        SurfWidget.update(context, glanceId)
    }
}

class SurfWidgetSortedEmailActionCallBack : ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters,
    ) {
        updateAppWidgetState(context, glanceId) { prefs ->
            prefs[SurfWidget.sortedListPositionKey] = RatingSorter.EMAIL.ordinal
            val newItems = getRatingUserInfoWidget(context, RatingSorter.EMAIL)
            prefs[SurfWidget.currentItemsKey] = newItems.toGson()
        }
        SurfWidget.update(context, glanceId)
    }
}