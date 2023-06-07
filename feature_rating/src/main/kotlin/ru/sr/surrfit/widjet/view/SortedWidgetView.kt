package ru.sr.surrfit.widjet.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.glance.Button
import androidx.glance.ButtonDefaults
import androidx.glance.GlanceModifier
import androidx.glance.appwidget.action.actionRunCallback
import androidx.glance.layout.Column
import androidx.glance.layout.Spacer
import androidx.glance.layout.size
import androidx.glance.layout.width
import androidx.glance.unit.ColorProvider
import ru.sr.surrfit.domain.model.RatingSorter
import ru.sr.surrfit.widjet.SurfWidgetSortedEmailActionCallBack
import ru.sr.surrfit.widjet.SurfWidgetSortedIdActionCallBack
import ru.sr.surrfit.widjet.SurfWidgetSortedModeActionCallBack
import ru.sr.surrfit.widjet.SurfWidgetSortedNameActionCallBack
import ru.sr.surrfit.widjet.SurfWidgetSortedStepActionCallBack

@Composable
fun SortedWidgetView(position: Int) {

    val listAction = listOf(
        actionRunCallback<SurfWidgetSortedIdActionCallBack>(),
        actionRunCallback<SurfWidgetSortedStepActionCallBack>(),
        actionRunCallback<SurfWidgetSortedModeActionCallBack>(),
        actionRunCallback<SurfWidgetSortedNameActionCallBack>(),
        actionRunCallback<SurfWidgetSortedEmailActionCallBack>(),
    )

    Column {
        RatingSorter.values().forEachIndexed { index, item ->
            Spacer(GlanceModifier.size(4.dp))
            Button(modifier = GlanceModifier.width(80.dp),
                text = item.name, onClick = (listAction[index]),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = ColorProvider(
                        color = if (position == index) Color(0xFF55847A) else Color(0xFFC4F3F3),
                    ),
                    contentColor = ColorProvider(
                        color = if (position != index) Color(0xFF55847A) else Color(0xFFC4F3F3),
                    )
                ),
            )
        }
    }
}
