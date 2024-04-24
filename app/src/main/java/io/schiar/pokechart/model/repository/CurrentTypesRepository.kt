package io.schiar.pokechart.model.repository

import io.schiar.pokechart.model.datasource.CurrentTypesDataSource
import io.schiar.pokechart.model.datasource.local.CurrentTypesLocalDataSource

class CurrentTypesRepository(
    currentTypesDataSource: CurrentTypesDataSource = CurrentTypesLocalDataSource()
) {
    val currentTypesFlow = currentTypesDataSource.retrieveCurrentTypes()
}