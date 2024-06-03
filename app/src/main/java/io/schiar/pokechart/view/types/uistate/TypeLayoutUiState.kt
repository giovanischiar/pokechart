package io.schiar.pokechart.view.types.uistate

import androidx.compose.runtime.Immutable
import io.schiar.pokechart.view.shared.viewdata.TypeLayoutViewData

@Immutable
sealed interface TypeLayoutUiState {
    data object Loading : TypeLayoutUiState
    data class TypeLayoutLoaded(val typeLayout: TypeLayoutViewData): TypeLayoutUiState
}