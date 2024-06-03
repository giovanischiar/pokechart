package io.schiar.pokechart.view.types.uistate

import androidx.compose.runtime.Immutable

@Immutable
sealed interface TypesIndicesUiState {
    data object Loading : TypesIndicesUiState
    data class TypesIndicesLoaded(val typesIndices: List<Int>): TypesIndicesUiState
}