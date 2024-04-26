package io.schiar.pokechart.view.types

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import io.schiar.pokechart.R
import io.schiar.pokechart.view.shared.viewdata.TypeLayoutViewData
import io.schiar.pokechart.view.types.component.IconButton
import io.schiar.pokechart.view.types.component.TypesView
import io.schiar.pokechart.viewmodel.TypesViewModel

@Composable
fun TypesScreen(
    typesViewModel: TypesViewModel = hiltViewModel(), navigateToCurrentTypes: () -> Unit
) {
    val types by typesViewModel.typesFlow.collectAsState(TypeLayoutViewData())
    val selectedTypesIndices by typesViewModel.selectedTypesIndicesStateFlow.collectAsState()
    val shouldInitiateNavigation by typesViewModel.shouldNavigateStateFlow.collectAsState()

    if (types.isEmpty()) return

    if (shouldInitiateNavigation) {
        navigateToCurrentTypes()
        typesViewModel.navigationInitiated()
    }

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