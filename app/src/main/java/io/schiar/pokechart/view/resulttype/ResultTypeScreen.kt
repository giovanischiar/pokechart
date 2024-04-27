package io.schiar.pokechart.view.resulttype

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import io.schiar.pokechart.view.resulttype.component.ResultTypeView
import io.schiar.pokechart.view.resulttype.component.TypesBar
import io.schiar.pokechart.viewmodel.ResultTypeViewModel

@Composable
fun ResultTypeScreen(resultTypeViewModel: ResultTypeViewModel = hiltViewModel()) {
    val optionalResultType by resultTypeViewModel.resultTypeFlow.collectAsState(initial = null)
    val resultType = optionalResultType ?: return

    Column {
        TypesBar(types = resultType.types)
        ResultTypeView(resultType = resultType)
    }
}