package com.baczek.movienight.ui.screen.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.baczek.movienight.domain.model.Asset
import com.baczek.movienight.ui.component.FullScreenLoader
import com.baczek.movienight.ui.component.AssetListItem
import com.baczek.movienight.ui.screen.details.navigateToDetails
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination<RootGraph>(start = true)
@Composable
fun MainScreen(
    navigator: DestinationsNavigator,
    viewModel: MainViewModel = hiltViewModel(),
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle().value

    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .consumeWindowInsets(paddingValues),
        ) {
            when (uiState) {
                is MainViewModel.MainUiState.Success -> SuccessScreen(
                    assets = uiState.assets,
                    navigateToDetails = navigator::navigateToDetails,
                )
                MainViewModel.MainUiState.Loading -> LoadingScreen()
                MainViewModel.MainUiState.Error -> ErrorScreen()
            }
        }
    }
}

@Composable
private fun SuccessScreen(
    assets: List<Asset>,
    navigateToDetails: (Int) -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.surface)
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        items(items = assets) { movie ->
            AssetListItem(
                modifier = Modifier.height(64.dp),
                data = movie,
                onClick = {
                    println("UI_DEBUG $movie")
                    navigateToDetails(movie.id)
                },
            )
        }
    }
}

@Composable
private fun LoadingScreen() {
    FullScreenLoader()
}

@Composable
private fun ErrorScreen() {
    Text(text = "MainScreen.Error")
}
