package ru.sr.surrfit.presentation.rating.compose.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.sr.nineteen.feature_rating.R
import ru.sr.surrfit.presentation.model.RatingUiModel
import ru.sr.surrfit.presentation.rating.viewmodel.model.RatingEvent
import ru.sr.surrfit.theme.SurfTheme

@Composable
fun ListRatingItemsView(
    ratingItems: List<RatingUiModel>,
    paddingValues: PaddingValues = PaddingValues(),
    eventHandler: (RatingEvent) -> Unit,
) {

    LazyColumn(Modifier.padding(paddingValues)) {
        itemsIndexed(ratingItems) { index, item ->
            if (index == 0) Spacer(modifier = Modifier.size(16.dp))
            RatingItemView(item) { ratingItem ->
                eventHandler(
                    RatingEvent.OnClickItemRating(ratingItem)
                )
            }
            Spacer(modifier = Modifier.size(8.dp))
        }
    }
}

@Composable
fun RatingItemView(
    item: RatingUiModel,
    onClickItem: (RatingUiModel) -> Unit,
) {
    Box(
        Modifier
            .fillMaxWidth()
            .clip(shape = SurfTheme.shapes.large)
            .background(color = SurfTheme.colors.green)
            .clickable { onClickItem(item) },
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.padding(end = 8.dp),
                text = item.id.toString(),
                style = SurfTheme.fonts.h2.copy(color = SurfTheme.colors.titleText)
            )
            Column {
                RatingInfoColumn(
                    stringResource(id = R.string.registration_user_name),
                    item.userName
                )
                RatingInfoColumn(stringResource(id = R.string.registration_user_email), item.email)
                RatingInfoColumn(
                    stringResource(id = R.string.registration_user_step_count),
                    item.stepCount.toString()
                )
                RatingInfoColumn(stringResource(id = R.string.registration_user_mode), item.mode)
            }
        }
    }

}

@Composable
private fun RatingInfoColumn(title: String, description: String) {
    Column {
        Text(
            text = title,
            style = SurfTheme.fonts.p
                .copy(color = SurfTheme.colors.text)
        )
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = description,
            style = SurfTheme.fonts.h4.copy(color = SurfTheme.colors.titleText)
        )
    }
}
