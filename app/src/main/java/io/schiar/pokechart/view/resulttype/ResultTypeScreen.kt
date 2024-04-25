package io.schiar.pokechart.view.resulttype

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import io.schiar.pokechart.view.resulttype.component.ResultTypeView
import io.schiar.pokechart.view.resulttype.component.TypesBar
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