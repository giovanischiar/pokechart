package io.schiar.pokechart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import dagger.hilt.android.AndroidEntryPoint
import io.schiar.pokechart.view.resulttype.resultTypeScreen
import io.schiar.pokechart.view.shared.Route
import io.schiar.pokechart.view.shared.Route.TYPES_ROUTE
import io.schiar.pokechart.view.shared.theme.PokechartTheme
import io.schiar.pokechart.view.types.typesScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
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
                typesScreen(
                    navigateToResultTypes = {
                        navController.navigate(route = Route.RESULT_TYPE_ROUTE.id)
                    }
                )
                resultTypeScreen()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun Preview() { Navigation() }
}