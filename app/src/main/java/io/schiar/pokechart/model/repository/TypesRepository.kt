package io.schiar.pokechart.model.repository

import io.schiar.pokechart.model.Type
import io.schiar.pokechart.model.datasource.CurrentTypesDataSource
import io.schiar.pokechart.model.datasource.TypesDataSource
import io.schiar.pokechart.model.datasource.local.CurrentTypesLocalDataSource
import io.schiar.pokechart.model.datasource.local.TypesLocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

class TypesRepository(
    typesDataSource: TypesDataSource = TypesLocalDataSource(),
    private val currentTypesDataSource: CurrentTypesDataSource = CurrentTypesLocalDataSource()
) {
    private var types: List<Type> = emptyList()
    val typesFlow: Flow<List<Type>> = typesDataSource.retrieveTypes().onEach { types = it }

    fun addTypeToCurrentTypesTheTypeAt(vararg indices: Int) {
        val types = indices.toList().mapNotNull { index -> types.getOrNull(index) }
        currentTypesDataSource.updateCurrentTypes(types)
    }
}