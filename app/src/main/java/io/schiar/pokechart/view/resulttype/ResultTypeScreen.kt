package io.schiar.pokechart.view.resulttype

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.wear.compose.material.CircularProgressIndicator
import io.schiar.pokechart.view.resulttype.component.ResultTypeView
import io.schiar.pokechart.view.resulttype.component.TypesBar

@Composable
fun ResultTypeScreen(resultTypeUiState: ResultTypeUiState) {
    when (resultTypeUiState) {
        is ResultTypeUiState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        is ResultTypeUiState.ResultTypeLoaded -> {
            val resultType = resultTypeUiState.resultType
            Column {
                TypesBar(types = resultType.types)
                ResultTypeView(resultType = resultType)
            }
        }
    }
}