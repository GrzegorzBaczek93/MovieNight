package com.baczek.movienight.ui.screen.country

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.baczek.movienight.R
import com.baczek.movienight.ui.component.VerticalSpacer
import com.baczek.movienight.ui.component.screen.FullScreenError
import com.baczek.movienight.ui.component.screen.FullScreenLoader
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootGraph
import com.ramcosta.composedestinations.generated.destinations.CountrySelectionScreenDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination<RootGraph>(start = true)
@Composable
fun CountrySelectionScreen(
    navigator: DestinationsNavigator,
    viewModel: CountrySelectionViewModel = hiltViewModel(),
) {
    when (val state = viewModel.uiState.collectAsStateWithLifecycle().value) {
        CountrySelectionViewModel.UiState.Loading -> LoadingScreen()
        CountrySelectionViewModel.UiState.Error -> ErrorScreen()
        is CountrySelectionViewModel.UiState.Success -> SuccessScreen(state)
    }
}

@Composable
private fun SuccessScreen(
    state: CountrySelectionViewModel.UiState.Success,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        VerticalSpacer(32.dp)
        Text(
            text = stringResource(R.string.select_country),
            style = MaterialTheme.typography.headlineMedium,
        )
        VerticalSpacer(40.dp)
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            state.countries.forEach { country ->
                Text(
                    text = country.name,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}

@Composable
private fun LoadingScreen() {
    FullScreenLoader()
}

@Composable
private fun ErrorScreen() {
    FullScreenError(
        text = "Wystąpił błąd",
        buttonText = "Odśwież",
        onClick = { }
    )
}

fun DestinationsNavigator.navigateToCountrySelection() {
    navigate(CountrySelectionScreenDestination)
}