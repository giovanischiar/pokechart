package io.schiar.pokechart.model.datasource.local

import io.schiar.pokechart.model.Type
import io.schiar.pokechart.model.datasource.CurrentTypesDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class CurrentTypesLocalDataSource: CurrentTypesDataSource {
    private var currentTypes = listOf<Type>()
    private val currentTypesMutableStateFlow = MutableStateFlow(currentTypes)

    override fun retrieveCurrentTypes(): Flow<List<Type>> {
        return currentTypesMutableStateFlow
    }

    override fun updateCurrentTypes(types: List<Type>) {
        currentTypes = types
        currentTypesMutableStateFlow.update { currentTypes }
    }
}