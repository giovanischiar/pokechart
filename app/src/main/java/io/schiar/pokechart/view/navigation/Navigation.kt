package io.schiar.pokechart.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import io.schiar.pokechart.view.resulttype.resultTypeScreen
import io.schiar.pokechart.view.shared.util.Route
import io.schiar.pokechart.view.shared.theme.PokechartTheme
import io.schiar.pokechart.view.types.typesScreen

@Composable
fun Navigation(navController: NavHostController = rememberSwipeDismissableNavController()) {
    PokechartTheme {
        SwipeDismissableNavHost(
            navController = navController,
            startDestination = Route.TYPES_ROUTE.id
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