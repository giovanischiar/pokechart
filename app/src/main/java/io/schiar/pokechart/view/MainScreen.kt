package io.schiar.pokechart.view

import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import io.schiar.pokechart.viewmodel.MainViewModel

@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModel) {
    val types by viewModel.types.collectAsState()
    LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
        items(types.size) { index ->
            Button(onClick = { navController.navigate("OtherScreen") }) {
                Text(types[index].name)
            }
        }
    }
}