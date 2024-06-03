package io.schiar.pokechart.view.types

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import io.schiar.pokechart.R
import io.schiar.pokechart.view.types.component.IconButton
import io.schiar.pokechart.view.types.component.TypesView
import io.schiar.pokechart.view.types.uistate.TypeLayoutUiState
import io.schiar.pokechart.view.types.uistate.TypesIndicesUiState

@Composable
fun TypesScreen(
    typeLayoutUiState: TypeLayoutUiState,
    selectedTypesIndicesUiState: TypesIndicesUiState,
    selectTypeAt: (index: Int) -> Unit,
    doneSelectingButtonWasPressed: () -> Unit,
    navigateToResultTypes: () -> Unit
) {
    val types = when (typeLayoutUiState) {
        is TypeLayoutUiState.Loading -> return
        is TypeLayoutUiState.TypeLayoutLoaded -> typeLayoutUiState.typeLayout
    }
    val selectedTypesIndices = when (selectedTypesIndicesUiState) {
        is TypesIndicesUiState.Loading -> return
        is TypesIndicesUiState.TypesIndicesLoaded -> selectedTypesIndicesUiState.typesIndices
    }

    if (types.isEmpty()) return

    fun handleDoneSelectingButtonPressed() {
        doneSelectingButtonWasPressed()
        navigateToResultTypes()
    }

    TypesView(
        types,
        selectedTypesIndices,
        onPressTypeAt = { index -> selectTypeAt(index) },
        lastRowButton = {
            IconButton(
                iconResourceID = R.drawable.baseline_done_24,
                contentDescriptionStringResourceID = R.string.done_selecting_multiple,
                iconTint = Color.Green,
                onPress = ::handleDoneSelectingButtonPressed
            )
        }
    )
}