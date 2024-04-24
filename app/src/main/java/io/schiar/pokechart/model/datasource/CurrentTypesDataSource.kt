package io.schiar.pokechart.model.datasource

import io.schiar.pokechart.model.Type
import kotlinx.coroutines.flow.Flow

interface CurrentTypesDataSource {
    fun retrieveCurrentTypes(): Flow<List<Type>>
    fun updateCurrentTypes(types: List<Type>)
}