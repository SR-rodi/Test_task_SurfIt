package ru.sr.surrfit.presentation.detail.compose.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.sr.surrfit.presentation.model.RatingUiModel
import ru.sr.surrfit.presentation.rating.compose.view.RatingItemView
import ru.sr.surrfit.theme.LocalNavigateController

@Composable
fun DetailScreen(item: RatingUiModel) {
    val navController = LocalNavigateController.current

    IconButton(onClick = { navController.popBackStack() }) {
        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription ="" )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), contentAlignment = Alignment.Center
    ) {
        RatingItemView(item){}
    }
}