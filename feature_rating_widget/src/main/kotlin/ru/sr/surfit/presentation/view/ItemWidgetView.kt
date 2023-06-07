package ru.sr.surfit.presentation.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceModifier
import androidx.glance.appwidget.cornerRadius
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.padding
import androidx.glance.layout.size
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import ru.sr.surfit.data.ListRatingWidgetModal

@Composable
fun ItemWidgetView(items: ListRatingWidgetModal) {
    Column(GlanceModifier.fillMaxWidth()) {
        items.items.forEach { item ->
            Spacer(GlanceModifier.size(4.dp))
            Row(
                modifier = GlanceModifier.fillMaxWidth().background(Color(0xFFC4F3F3)).cornerRadius(16.dp).padding(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = item.id.toString())
                Spacer(GlanceModifier.size(4.dp))
                Text(text = item.userName)
                Spacer(GlanceModifier.size(4.dp))
                Column {
                    Row {
                        Column {
                            Text(text = "Step", style = TextStyle(fontSize = 10.sp))
                            Text(text = item.stepCount.toString())
                        }
                        Spacer(GlanceModifier.size(8.dp))
                        Column {
                            Text(text = "Mode", style = TextStyle(fontSize = 10.sp))
                            Text(text = item.mode)
                        }
                    }
                    Column {
                        Text(text = "email", style = TextStyle(fontSize = 10.sp))
                        Text(text = item.email)
                    }
                }
                Spacer(GlanceModifier.size(4.dp))
            }

        }
    }
}