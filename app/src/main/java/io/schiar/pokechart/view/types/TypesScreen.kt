package io.schiar.pokechart.view.types

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import io.schiar.pokechart.R
import io.schiar.pokechart.view.shared.viewdata.TypeLayoutViewData
import io.schiar.pokechart.view.types.component.IconButton
import io.schiar.pokechart.view.types.component.TypesView
import io.schiar.pokechart.viewmodel.TypesViewModel

@Composable
fun TypesScreen(typesViewModel: TypesViewModel, navigateToCurrentTypes: () -> Unit) {
    val types by typesViewModel.typesFlow.collectAsState(TypeLayoutViewData())
    val selectedTypesIndices by typesViewModel.selectedTypesIndicesStateFlow.collectAsState()
    val shouldNavigateToCurrentTypes by typesViewModel
        .shouldNavigateToResultTypeStateFlow
        .collectAsState()

    if (types.isEmpty()) return
    if (shouldNavigateToCurrentTypes) navigateToCurrentTypes()

    TypesView(
        types,
        selectedTypesIndices,
        onPressTypeAt = { index -> typesViewModel.selectTypeAt(index) } ,
        lastRowButton = {
            IconButton(
                iconResourceID = R.drawable.baseline_done_24,
                contentDescriptionStringResourceID = R.string.done_selecting_multiple,
                iconTint = Color.Green,
                onPress = typesViewModel::doneSelectingButtonWasPressed,
            )
        }
    )
}