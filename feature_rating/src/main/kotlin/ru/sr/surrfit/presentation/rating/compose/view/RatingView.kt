package ru.sr.surrfit.presentation.rating.compose.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.sr.surrfit.presentation.rating.viewmodel.RatingEvent
import ru.sr.surrfit.presentation.rating.viewmodel.RatingState

@Composable
fun RatingView(state: RatingState, eventHandler: (RatingEvent) -> Unit) {
    Column {
        SearchView(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            value = state.search,
            onValueChange = { newSearch -> eventHandler(RatingEvent.OnSearch(newSearch)) },
            searchItems = state.searchItems,
            onClickTrailingIcon = { eventHandler(RatingEvent.OnClearSearch) },
            onClickItem = { ratingItem -> eventHandler(RatingEvent.OnClickItemRating(ratingItem)) }
        )
        Spacer(modifier = Modifier.size(8.dp))
        RatingSorterView(eventHandler = eventHandler)
        Spacer(modifier = Modifier.size(8.dp))
        ListRatingItemsView(
            ratingItems = state.items,
            paddingValues = PaddingValues(horizontal = 16.dp),
            eventHandler = eventHandler
        )
    }

}