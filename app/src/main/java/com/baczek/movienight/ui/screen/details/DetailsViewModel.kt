package com.baczek.movienight.ui.screen.details

import androidx.lifecycle.ViewModel
import com.baczek.movienight.domain.model.Movie
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel(assistedFactory = DetailsViewModel.Factory::class)
class DetailsViewModel @AssistedInject constructor(
    @Assisted private val id: Int,
) : ViewModel() {
    private var _uiState = MutableStateFlow<DetailsUiState>(DetailsUiState.Loading)
    val uiState: StateFlow<DetailsUiState> = _uiState.asStateFlow()

    init {
        println("UI_DEBUG DetailsViewModel $id")
    }

    val movieId = id

    sealed interface DetailsUiState {
        data class Success(
            val movie: Movie,
        )

        data object Loading : DetailsUiState

        data object Error : DetailsUiState
    }

    @AssistedFactory
    interface Factory {
        fun create(id: Int): DetailsViewModel
    }
}