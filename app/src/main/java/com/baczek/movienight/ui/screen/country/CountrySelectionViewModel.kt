package com.baczek.movienight.ui.screen.country

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baczek.movienight.domain.model.country.Country
import com.baczek.movienight.domain.usecase.GetCountriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountrySelectionViewModel @Inject constructor(
    private val getCountriesUseCase: GetCountriesUseCase,
) : ViewModel() {
    private var _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    init {
        getCountries()
    }

    private fun getCountries() {
        viewModelScope.launch {
            runCatching {
                getCountriesUseCase()
            }.onSuccess {
                _uiState.value = UiState.Success(
                    countries = it
                )
            }.onFailure {
                _uiState.value = UiState.Error
            }
        }
    }

    sealed interface UiState {
        data class Success(
            val countries: List<Country>,
        ) : UiState

        data object Loading : UiState
        data object Error : UiState
    }
}