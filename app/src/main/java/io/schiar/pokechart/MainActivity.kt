package io.schiar.pokechart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.schiar.pokechart.view.MainScreen
import io.schiar.pokechart.view.OtherScreen
import io.schiar.pokechart.view.theme.PokechartTheme
import io.schiar.pokechart.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            PokechartTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController = navController, startDestination = "MainScreen") {
                        composable("MainScreen")  { MainScreen(
                            navController = navController,
                            viewModel = MainViewModel()
                        ) }
                        composable("OtherScreen")  { OtherScreen(viewModel = MainViewModel()) }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val navController = rememberNavController()

    PokechartTheme {
        MainScreen(navController = navController, viewModel = MainViewModel())
    }
}