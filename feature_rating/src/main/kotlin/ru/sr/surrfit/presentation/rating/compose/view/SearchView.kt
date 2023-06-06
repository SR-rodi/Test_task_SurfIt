package ru.sr.surrfit.presentation.rating.compose.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import ru.sr.nineteen.feature_rating.R
import ru.sr.surrfit.presentation.model.RatingUiModel

import ru.sr.surrfit.theme.SurfTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchView(
    value: String,
    onValueChange: (String) -> Unit,
    searchItems: List<RatingUiModel>,
    modifier: Modifier = Modifier,
    hintId: Int = R.string.registration_search_hint,
    colors: TextFieldColors = TextFieldDefaults.outlinedTextFieldColors(
        focusedBorderColor = SurfTheme.colors.green,
        unfocusedBorderColor = SurfTheme.colors.green,
        focusedLabelColor = SurfTheme.colors.green,
        cursorColor = SurfTheme.colors.green,
        selectionColors = TextSelectionColors(
            handleColor = SurfTheme.colors.green, backgroundColor = SurfTheme.colors.background
        )
    ),
    onClickTrailingIcon: () -> Unit = {},
    onClickItem: (RatingUiModel) -> Unit = {}
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            modifier = modifier,
            value = value,
            onValueChange = onValueChange,
            leadingIcon = {
                Icon(
                    modifier = Modifier.size(20.dp),
                    imageVector = Icons.Filled.Search,
                    contentDescription = null,
                    tint = SurfTheme.colors.green
                )
            },
            trailingIcon = {
                IconButton(onClick = onClickTrailingIcon) {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        imageVector = Icons.Filled.Clear,
                        contentDescription = null,
                        tint = SurfTheme.colors.green
                    )
                }
            },
            label = { Text(text = stringResource(id = hintId)) },
            colors = colors
        )
        ExpectedSearchView(modifier = modifier, ratings = searchItems, value != ""){ rating->
            onClickItem(rating)
        }

    }
}

@Composable
fun ExpectedSearchView(
    modifier: Modifier = Modifier,
    ratings: List<RatingUiModel>,
    isVisible: Boolean,
    onClickItem: (RatingUiModel) -> Unit,
) {
    AnimatedVisibility(
        visible = isVisible,
    ) {
        LazyColumn(
            modifier.border(
                width = 2.dp,
                color = SurfTheme.colors.green,
                shape = SurfTheme.shapes.search
            )
        ) {
            items(ratings) { item ->
                Row(
                    modifier = Modifier.padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column {
                        Text(text = item.userName)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = item.email)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(onClick = { onClickItem(item) }) {
                        Icon(imageVector = Icons.Filled.ArrowForward, contentDescription = "")
                    }
                }

            }
        }
    }

}