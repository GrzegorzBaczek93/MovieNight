package com.baczek.movienight.ui.screen.details

import androidx.lifecycle.ViewModel
import com.baczek.movienight.domain.model.asset.Asset
import com.baczek.movienight.domain.usecase.GetAssetUseCase
import com.baczek.movienight.utils.debug
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel(assistedFactory = DetailsViewModel.Factory::class)
class DetailsViewModel @AssistedInject constructor(
    @Assisted private val id: Int,
    private val getAssetUseCase: GetAssetUseCase,
) : ViewModel() {
    private var _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    init {
        debug { "DetailsViewModel $id" }
    }


    sealed interface UiState {
        data class Success(
            val asset: Asset,
        )

        data object Loading : UiState

        data object Error : UiState
    }

    @AssistedFactory
    interface Factory {
        fun create(id: Int): DetailsViewModel
    }
}