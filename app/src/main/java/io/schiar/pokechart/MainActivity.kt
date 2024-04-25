package io.schiar.pokechart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import io.schiar.pokechart.model.datasource.local.ResultTypeLocalDataSource
import io.schiar.pokechart.model.datasource.local.TypesLocalDataSource
import io.schiar.pokechart.model.repository.ResultTypeRepository
import io.schiar.pokechart.model.repository.TypesRepository
import io.schiar.pokechart.view.ResultTypeScreen
import io.schiar.pokechart.view.TypesScreen
import io.schiar.pokechart.view.theme.PokechartTheme
import io.schiar.pokechart.viewmodel.ResultTypeViewModel
import io.schiar.pokechart.viewmodel.TypesViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val typesDataSource = TypesLocalDataSource()
        val currentTypesDataSource = ResultTypeLocalDataSource()
        val typesRepository = TypesRepository(typesDataSource, currentTypesDataSource)
        val currentTypesRepository = ResultTypeRepository(currentTypesDataSource)

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
                        ResultTypeScreen(
                            resultTypeViewModel = ResultTypeViewModel(currentTypesRepository)
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
    val currentTypesDataSource = ResultTypeLocalDataSource()
    val typesRepository = TypesRepository(typesDataSource, currentTypesDataSource)
    val currentTypesRepository = ResultTypeRepository(currentTypesDataSource)
    val typesViewModel = TypesViewModel(typesRepository)
    val currentTypesViewModel = ResultTypeViewModel(currentTypesRepository)

    PokechartTheme {
        SwipeDismissableNavHost(navController = navController, startDestination = "TypesScreen") {
            composable("TypesScreen") {
                TypesScreen(typesViewModel) { navController.navigate(route = "CurrentTypesScreen") }
            }
            composable("CurrentTypesScreen") { ResultTypeScreen(currentTypesViewModel) }
        }
    }
}