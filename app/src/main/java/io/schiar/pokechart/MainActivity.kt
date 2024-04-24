package io.schiar.pokechart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import io.schiar.pokechart.model.datasource.local.CurrentTypesLocalDataSource
import io.schiar.pokechart.model.datasource.local.TypesLocalDataSource
import io.schiar.pokechart.model.repository.CurrentTypesRepository
import io.schiar.pokechart.model.repository.TypesRepository
import io.schiar.pokechart.view.CurrentTypesScreen
import io.schiar.pokechart.view.TypesScreen
import io.schiar.pokechart.view.theme.PokechartTheme
import io.schiar.pokechart.viewmodel.CurrentTypesViewModel
import io.schiar.pokechart.viewmodel.TypesViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val typesDataSource = TypesLocalDataSource()
        val currentTypesDataSource = CurrentTypesLocalDataSource()
        val typesRepository = TypesRepository(typesDataSource, currentTypesDataSource)
        val currentTypesRepository = CurrentTypesRepository(currentTypesDataSource)

        setContent {
            val navController = rememberSwipeDismissableNavController()
            PokechartTheme {
                SwipeDismissableNavHost(
                    navController = navController,
                    startDestination = "TypesScreen"
                ) {
                    composable("TypesScreen") {
                        TypesScreen(typesViewModel = TypesViewModel(typesRepository)) {
                            navController.navigate(route = "CurrentTypesScreen")
                        }
                    }
                    composable("CurrentTypesScreen") {
                        CurrentTypesScreen(
                            currentTypesViewModel = CurrentTypesViewModel(currentTypesRepository)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val navController = rememberSwipeDismissableNavController()
    val typesDataSource = TypesLocalDataSource()
    val currentTypesDataSource = CurrentTypesLocalDataSource()
    val typesRepository = TypesRepository(typesDataSource, currentTypesDataSource)
    val currentTypesRepository = CurrentTypesRepository(currentTypesDataSource)
    val typesViewModel = TypesViewModel(typesRepository)
    val currentTypesViewModel = CurrentTypesViewModel(currentTypesRepository)

    PokechartTheme {
        SwipeDismissableNavHost(navController = navController, startDestination = "TypesScreen") {
            composable("TypesScreen") {
                TypesScreen(typesViewModel) { navController.navigate(route = "CurrentTypesScreen") }
            }
            composable("CurrentTypesScreen") { CurrentTypesScreen(currentTypesViewModel) }
        }
    }
}