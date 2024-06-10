package io.schiar.pokechart.view.types.uistate

import androidx.compose.runtime.Immutable

@Immutable
sealed interface SelectedTypesIndicesUiState {
    data object Loading : SelectedTypesIndicesUiState
    data class SelectedTypesIndicesLoaded(val typesIndices: List<Int>): SelectedTypesIndicesUiState
}