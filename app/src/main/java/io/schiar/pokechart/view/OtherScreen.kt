package io.schiar.pokechart.view

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.schiar.pokechart.viewmodel.MainViewModel

@Composable
fun OtherScreen(viewModel: MainViewModel) {
    val types by viewModel.types.collectAsState()
    Box(contentAlignment = Alignment.Center) {
        Text(modifier = Modifier.align(Alignment.Center), text = "Hello")
    }
}