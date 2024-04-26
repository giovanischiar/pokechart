package io.schiar.pokechart.model.repository

import io.schiar.pokechart.model.Type
import io.schiar.pokechart.model.asType
import io.schiar.pokechart.model.datasource.ResultTypeDataSource
import io.schiar.pokechart.model.datasource.TypesDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class TypesRepository @Inject constructor(
    typesDataSource: TypesDataSource,
    private val currentTypesDataSource: ResultTypeDataSource
) {
    private var types: List<Type> = emptyList()
    val typesFlow: Flow<List<Type>> = typesDataSource.retrieveTypes().onEach { types = it }

    fun addTypesToResultTypeTheTypesAt(indices: List<Int>) {
        val types = indices.mapNotNull { index -> types.getOrNull(index) }
        currentTypesDataSource.updateResultType(resultType = types.asType())
    }
}