package com.baczek.movienight.ui.screen.details

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
    Text(text = "Details Screen $id")
}

fun DestinationsNavigator.navigateToDetails(id: Int) {
    navigate(DetailsScreenDestination(id))
}