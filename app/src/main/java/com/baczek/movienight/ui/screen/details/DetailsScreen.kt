package com.baczek.movienight.ui.screen.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootGraph
import com.ramcosta.composedestinations.generated.destinations.DetailsScreenDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination<RootGraph>
@Composable
fun DetailsScreen(
    id: Int,
    navigator: DestinationsNavigator,
    viewModel: DetailsViewModel = hiltViewModel<DetailsViewModel, DetailsViewModel.Factory>(
        creationCallback = { factory -> factory.create(id) }
    ),
) {
    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .consumeWindowInsets(paddingValues),
        ) {
            Text(text = "Details Screen $id")
        }
    }
}

fun DestinationsNavigator.navigateToDetails(id: Int) {
    navigate(DetailsScreenDestination(id))
}