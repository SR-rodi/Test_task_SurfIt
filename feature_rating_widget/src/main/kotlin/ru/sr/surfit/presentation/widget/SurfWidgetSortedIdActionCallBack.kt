package ru.sr.surfit.presentation.widget

import android.content.Context
import androidx.glance.GlanceId
import androidx.glance.action.ActionParameters
import androidx.glance.appwidget.action.ActionCallback
import androidx.glance.appwidget.state.updateAppWidgetState
import ru.sr.surfit.mapper.getRatingUserInfoWidget
import ru.sr.surfit.mapper.toGson
import ru.sr.surrfit.RatingSorter

class SurfWidgetSortedIdActionCallBack : ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters,
    ) {
        updateSurfWidget(context,glanceId,RatingSorter.ID)
    }
}

class SurfWidgetSortedStepActionCallBack : ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters,
    ) {
        updateSurfWidget(context,glanceId,RatingSorter.STEP)
    }
}

class SurfWidgetSortedModeActionCallBack : ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters,
    ) {
        updateSurfWidget(context,glanceId,RatingSorter.MODE)
    }
}

class SurfWidgetSortedNameActionCallBack : ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters,
    ) {
        updateSurfWidget(context,glanceId,RatingSorter.USER_NAME)
    }
}

class SurfWidgetSortedEmailActionCallBack : ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters,
    ) {
        updateSurfWidget(context,glanceId,RatingSorter.EMAIL)
    }
}

private suspend fun updateSurfWidget(context: Context, glanceId: GlanceId, ratingSorter: RatingSorter) {
    updateAppWidgetState(context, glanceId) { prefs ->
        prefs[SurfWidget.sortedListPositionKey] = ratingSorter.ordinal
        val newItems = getRatingUserInfoWidget(context, ratingSorter)
        prefs[SurfWidget.currentItemsKey] = newItems.toGson()
    }
    SurfWidget.update(context, glanceId)

}