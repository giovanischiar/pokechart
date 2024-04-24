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
import io.schiar.pokechart.viewmodel.TypesViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TypesScreen(typesViewModel: TypesViewModel, onNavigateToType: () -> Unit) {
    val types by typesViewModel.typesFlow.collectAsState(emptyList())

    fun onTypePressedAt(index: Int) {
        typesViewModel.addTypeToCurrentTypesTheTypeAt(index)
        onNavigateToType()
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row {
                (if (types.size > 2) types.subList(0, 2) else emptyList())
                    .mapIndexed { index, type ->
                        TypeView(type = type) { onTypePressedAt(index) }
                    }
            }

            FlowRow(
                maxItemsInEachRow = 5,
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                val offset = 2
                (if (types.size > 2) types.subList(offset, types.size - 1) else emptyList())
                    .mapIndexed { index, type ->
                        TypeView(type = type) { onTypePressedAt(index = index + offset) }
                    }
            }

            Row {
                val offset = types.size - 1
                (if (types.size > 1) types.subList(offset, types.size) else emptyList())
                    .mapIndexed { index, type ->
                        TypeView(type = type) { onTypePressedAt(index = index + offset) }
                    }
            }
        }
    }
}