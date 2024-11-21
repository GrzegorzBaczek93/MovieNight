package com.baczek.movienight.ui.screen.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baczek.movienight.domain.model.Asset
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    private var _uiState = MutableStateFlow<MainUiState>(MainUiState.Loading)
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            delay(3000L)
            _uiState.value =
                MainUiState.Success(
                    assets = listOf(Asset.mock),
                )
        }
    }

    sealed interface MainUiState {
        data class Success(
            val assets: List<Asset>,
        ) : MainUiState

        data object Loading : MainUiState

        data object Error : MainUiState
    }
}
