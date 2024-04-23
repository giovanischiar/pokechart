package io.schiar.pokechart.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.schiar.pokechart.view.components.TypeView
import io.schiar.pokechart.view.viewdata.TypeViewData
import io.schiar.pokechart.viewmodel.MainViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TypesScreen(viewModel: MainViewModel, onNavigateToType: () -> Unit) {
    val types by viewModel.types.collectAsState()

    fun onTypePressed(type: TypeViewData) {
        viewModel.addCurrentType(typeName = type.name)
        onNavigateToType()
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row {
                types.subList(0, 2).map { type ->
                    TypeView(type = type) { onTypePressed(type = type) }
                }
            }

            FlowRow(
                maxItemsInEachRow = 5,
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                types.subList(2, types.size - 1).map { type ->
                    TypeView(type = type) { onTypePressed(type = type) }
                }
            }

            Row {
                types.subList(types.size - 1, types.size).map { type ->
                    TypeView(type = type) { onTypePressed(type = type) }
                }
            }
        }
    }
}