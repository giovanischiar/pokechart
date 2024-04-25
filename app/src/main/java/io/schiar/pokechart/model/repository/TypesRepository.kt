package io.schiar.pokechart.model.repository

import io.schiar.pokechart.model.Type
import io.schiar.pokechart.model.asType
import io.schiar.pokechart.model.datasource.ResultTypeDataSource
import io.schiar.pokechart.model.datasource.TypesDataSource
import io.schiar.pokechart.model.datasource.local.ResultTypeLocalDataSource
import io.schiar.pokechart.model.datasource.local.TypesLocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

class TypesRepository(
    typesDataSource: TypesDataSource = TypesLocalDataSource(),
    private val currentTypesDataSource: ResultTypeDataSource = ResultTypeLocalDataSource()
) {
    private var types: List<Type> = emptyList()
    val typesFlow: Flow<List<Type>> = typesDataSource.retrieveTypes().onEach { types = it }

    fun addTypesToResultTypeTheTypesAt(indices: List<Int>) {
        val types = indices.mapNotNull { index -> types.getOrNull(index) }
        currentTypesDataSource.updateResultType(resultType = types.asType())
    }
}