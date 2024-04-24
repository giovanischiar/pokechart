package io.schiar.pokechart.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Icon
import io.schiar.pokechart.R
import io.schiar.pokechart.view.components.TypeView
import io.schiar.pokechart.view.theme.Pink80
import io.schiar.pokechart.viewmodel.TypesViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TypesScreen(typesViewModel: TypesViewModel, onNavigateToType: () -> Unit) {
    val types by typesViewModel.typesFlow.collectAsState(emptyList())
    var isSelectingMultiple by remember { mutableStateOf(value = false) }
    var typeIndicesSelected by remember { mutableStateOf(listOf<Int>()) }

    fun Boolean.icon(): Int {
        return if (this) R.drawable.baseline_done_24 else R.drawable.outline_content_copy_24
    }

    fun Boolean.color(): Color {
        return if (this) Color.Green else Pink80
    }

    fun Boolean.contentDescription(): Int {
        return if (this) R.string.done_selecting_multiple else R.string.select_multiple
    }

    fun onTypePressedAt(index: Int) {
        if (isSelectingMultiple) {
            if (typeIndicesSelected.contains(index)) {
                val mutableTypeIndicesSelected = typeIndicesSelected.toMutableList()
                mutableTypeIndicesSelected.remove(index)
                typeIndicesSelected = mutableTypeIndicesSelected
                if (mutableTypeIndicesSelected.isEmpty()) isSelectingMultiple = false
                return
            }

            typeIndicesSelected = listOf(index) + typeIndicesSelected
            return
        }

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
                        TypeView(
                            type = type,
                            isSelected = typeIndicesSelected.contains(index)
                        ) { onTypePressedAt(index) }
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
                        val indexFromTypesList = index + offset
                        TypeView(
                            type = type,
                            isSelected = typeIndicesSelected.contains(indexFromTypesList)
                        ) { onTypePressedAt(index = indexFromTypesList) }
                    }
            }

            Row {
                val offset = types.size - 1
                (if (types.size > 1) types.subList(offset, types.size) else emptyList())
                    .mapIndexed { index, type ->
                        val indexFromTypesList = index + offset
                        TypeView(
                            type = type,
                            isSelected = typeIndicesSelected.contains(indexFromTypesList)
                        ) { onTypePressedAt(index = indexFromTypesList) }
                    }

                Button(
                    modifier = Modifier
                        .padding(all = 3.dp)
                        .width(30.dp)
                        .height(30.dp),
                    onClick = {
                        if (!isSelectingMultiple) {
                            isSelectingMultiple = true
                        } else {
                            if (typeIndicesSelected.isEmpty()) {
                                isSelectingMultiple = false
                                return@Button
                            }
                            typesViewModel.addTypeToCurrentTypesTheTypeAt(
                                *typeIndicesSelected.toIntArray()
                            )
                            onNavigateToType()
                        }
                    }
                ) {
                    Icon(
                        modifier = Modifier.padding(all = 4.dp),
                        painter = painterResource(id = isSelectingMultiple.icon()),
                        contentDescription = stringResource(
                            id = isSelectingMultiple.contentDescription()
                        ),
                        tint = isSelectingMultiple.color()
                    )
                }
            }
        }
    }
}