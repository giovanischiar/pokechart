package io.schiar.pokechart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import io.schiar.pokechart.model.datasource.local.ResultTypeLocalDataSource
import io.schiar.pokechart.model.datasource.local.TypesLocalDataSource
import io.schiar.pokechart.model.repository.ResultTypeRepository
import io.schiar.pokechart.model.repository.TypesRepository
import io.schiar.pokechart.view.resulttype.ResultTypeScreen
import io.schiar.pokechart.view.shared.Route.RESULT_TYPE_ROUTE
import io.schiar.pokechart.view.shared.Route.TYPES_ROUTE
import io.schiar.pokechart.view.shared.theme.PokechartTheme
import io.schiar.pokechart.view.types.TypesScreen
import io.schiar.pokechart.viewmodel.ResultTypeViewModel
import io.schiar.pokechart.viewmodel.TypesViewModel

class MainActivity : ComponentActivity() {
    private val typesDataSource = TypesLocalDataSource()
    private val currentTypesDataSource = ResultTypeLocalDataSource()
    private val typesRepository = TypesRepository(typesDataSource, currentTypesDataSource)
    private val currentTypesRepository = ResultTypeRepository(currentTypesDataSource)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { Navigation() }
    }

    @Composable
    fun Navigation(navController: NavHostController = rememberSwipeDismissableNavController()) {
        PokechartTheme {
            SwipeDismissableNavHost(
                navController = navController,
                startDestination = TYPES_ROUTE.id
            ) {
                composable(TYPES_ROUTE.id) {
                    TypesScreen(typesViewModel = TypesViewModel(typesRepository)) {
                        navController.navigate(route = RESULT_TYPE_ROUTE.id)
                    }
                }
                composable(RESULT_TYPE_ROUTE.id) {
                    ResultTypeScreen(
                        resultTypeViewModel = ResultTypeViewModel(currentTypesRepository)
                    )
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun Preview() { Navigation() }
}