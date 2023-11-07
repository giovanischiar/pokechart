package io.schiar.pokechart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import io.schiar.pokechart.view.MainScreen
import io.schiar.pokechart.view.OtherScreen
import io.schiar.pokechart.view.theme.PokechartTheme
import io.schiar.pokechart.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberSwipeDismissableNavController()
            PokechartTheme {
                SwipeDismissableNavHost(
                    navController = navController,
                    startDestination = "MainScreen"
                ) {
                    composable("MainScreen") {
                        MainScreen(
                            navController = navController,
                            viewModel = MainViewModel()
                        )
                    }
                    composable("OtherScreen") { OtherScreen() }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val navController = rememberSwipeDismissableNavController()
    PokechartTheme {
        SwipeDismissableNavHost(navController = navController, startDestination = "MainScreen") {
            composable("MainScreen") {
                MainScreen(
                    navController = navController,
                    viewModel = MainViewModel()
                )
            }
            composable("OtherScreen") { OtherScreen() }
        }
    }
}