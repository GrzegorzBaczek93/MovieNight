package com.baczek.movienight.ui.screen.main

import androidx.lifecycle.ViewModel
import com.baczek.movienight.domain.model.asset.Asset
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    private var _uiState = MutableStateFlow<UiState>(UiState.Error)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    init {

    }

    sealed interface UiState {
        data class Success(
            val assets: List<Asset>,
        ) : UiState

        data object Loading : UiState

        data object Error : UiState
    }
}
