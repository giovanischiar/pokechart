package io.schiar.pokechart.view.types

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.wear.compose.navigation.composable
import io.schiar.pokechart.view.shared.util.Route
import io.schiar.pokechart.view.types.uistate.TypeLayoutUiState
import io.schiar.pokechart.view.types.uistate.SelectedTypesIndicesUiState
import io.schiar.pokechart.viewmodel.TypesViewModel

fun NavGraphBuilder.typesScreen(navigateToResultTypes : () -> Unit) {
    composable(Route.TYPES_ROUTE.id) {
        val typesViewModel = hiltViewModel<TypesViewModel>()
        val typeLayoutUiState by typesViewModel
            .typeLayoutUiStateFlow
            .collectAsState(initial = TypeLayoutUiState.Loading)
        val selectedTypesIndicesUiState by typesViewModel
            .selectedTypesIndicesUiStateStateFlow
            .collectAsState(initial = SelectedTypesIndicesUiState.Loading)
        TypesScreen(
            typeLayoutUiState = typeLayoutUiState,
            selectedTypesIndicesUiState = selectedTypesIndicesUiState,
            selectTypeAt = typesViewModel::selectTypeAt,
            doneSelectingButtonWasPressed = typesViewModel::doneSelectingButtonWasPressed,
            navigateToResultTypes = navigateToResultTypes
        )
    }
}