package io.schiar.pokechart.view.resulttype

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.wear.compose.navigation.composable
import io.schiar.pokechart.view.shared.util.Route
import io.schiar.pokechart.viewmodel.ResultTypeViewModel

fun NavGraphBuilder.resultTypeScreen() {
    composable(Route.RESULT_TYPE_ROUTE.id) {
        val resultTypeViewModel = hiltViewModel<ResultTypeViewModel>()
        val resultTypeUiState by resultTypeViewModel
            .resultTypeUiStateFlow
            .collectAsState(initial = ResultTypeUiState.Loading)
        ResultTypeScreen(resultTypeUiState = resultTypeUiState)
    }
}