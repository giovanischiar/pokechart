package io.schiar.pokechart.view.types.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.schiar.pokechart.view.shared.viewdata.TypeLayoutViewData
import io.schiar.pokechart.viewmodel.util.centralRowColumnMaxSize

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TypesView(
    types: TypeLayoutViewData,
    selectedTypesIndices: List<Int>,
    onPressTypeAt: (Int) -> Unit,
    lastRowButton: @Composable () -> Unit
) {
    val (upperRow, centralRows, lowerRow) = types
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row {
                upperRow.map { (index, type) ->
                    val isTypeSelected = selectedTypesIndices.contains(index)
                    TypeView(type = type, isSelected = isTypeSelected) { onPressTypeAt(index) }
                }
            }

            FlowRow(
                maxItemsInEachRow = centralRowColumnMaxSize,
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                centralRows.map { (index, type) ->
                    val isTypeSelected = selectedTypesIndices.contains(index)
                    TypeView(type = type, isSelected = isTypeSelected) { onPressTypeAt(index) }
                }
            }

            Row {
                lowerRow.map { (index, type) ->
                    val isTypeSelected = selectedTypesIndices.contains(index)
                    TypeView(type = type, isSelected = isTypeSelected) { onPressTypeAt(index) }
                }

                lastRowButton()
            }
        }
    }
}