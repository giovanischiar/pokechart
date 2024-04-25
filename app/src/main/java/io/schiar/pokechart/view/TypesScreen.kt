package io.schiar.pokechart.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import io.schiar.pokechart.R
import io.schiar.pokechart.view.components.IconButton
import io.schiar.pokechart.view.components.TypesView
import io.schiar.pokechart.view.viewdata.TypesViewData
import io.schiar.pokechart.viewmodel.TypesViewModel

@Composable
fun TypesScreen(typesViewModel: TypesViewModel, navigateToCurrentTypes: () -> Unit) {
    val types by typesViewModel.typesFlow.collectAsState(TypesViewData())
    val selectedTypesIndices by typesViewModel.selectedTypesIndicesStateFlow.collectAsState()
    val shouldNavigateToCurrentTypes by typesViewModel
        .shouldNavigateToCurrentTypesStateFlow
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