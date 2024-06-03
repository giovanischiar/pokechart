package io.schiar.pokechart.view.resulttype

import androidx.compose.runtime.Immutable
import io.schiar.pokechart.view.shared.viewdata.ResultTypeViewData

@Immutable
sealed interface ResultTypeUiState {
    data object Loading : ResultTypeUiState
    data class ResultTypeLoaded(val resultType: ResultTypeViewData): ResultTypeUiState
}