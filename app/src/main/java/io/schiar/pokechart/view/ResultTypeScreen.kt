package io.schiar.pokechart.view

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import io.schiar.pokechart.view.components.ResultTypeView
import io.schiar.pokechart.view.components.TypesBar
import io.schiar.pokechart.viewmodel.ResultTypeViewModel

@Composable
fun ResultTypeScreen(resultTypeViewModel: ResultTypeViewModel) {
    val optionalResultType by resultTypeViewModel.resultTypeFlow.collectAsState(initial = null)
    val resultType = optionalResultType ?: return

    Column {
        TypesBar(typeNames = resultType.names)
        ResultTypeView(resultType = resultType)
    }
}