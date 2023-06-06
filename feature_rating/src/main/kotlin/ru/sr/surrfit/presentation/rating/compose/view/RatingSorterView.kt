package ru.sr.surrfit.presentation.rating.compose.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.sr.surrfit.domain.model.RatingSorter
import ru.sr.surrfit.presentation.rating.viewmodel.RatingEvent
import ru.sr.surrfit.theme.SurfTheme

@Composable
fun RatingSorterView(startPadding: Dp = 16.dp, eventHandler: (RatingEvent) -> Unit) {
    var position by remember { mutableStateOf(0) }
    LazyRow {
        itemsIndexed(RatingSorter.values()) { index, item ->
            if (index == 0) Spacer(modifier = Modifier.size(startPadding))
            RatingSorterItemView(stringResource(id = item.fieldSorter), position == index) {
                position = index
                eventHandler(RatingEvent.OnGetRatingBySorter(item))
            }
            Spacer(modifier = Modifier.size(8.dp))
        }
    }

}

@Composable
fun RatingSorterItemView(sorter: String, isSelection: Boolean, onClickItem: () -> Unit) {
    Box(
        Modifier
            .clip(shape = SurfTheme.shapes.medium)
            .background(if (isSelection) SurfTheme.colors.green else SurfTheme.colors.background)
            .border(
                width = 2.dp,
                color = SurfTheme.colors.green,
                shape = SurfTheme.shapes.medium
            )
            .clickable { onClickItem() }
    ) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = sorter,
            style = SurfTheme.fonts.h4.copy(
                color = if (isSelection)   SurfTheme.colors.background else SurfTheme.colors.green
            )
        )
    }
}