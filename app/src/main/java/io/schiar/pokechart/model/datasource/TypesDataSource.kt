package io.schiar.pokechart.model.datasource

import io.schiar.pokechart.model.Type
import kotlinx.coroutines.flow.Flow

interface TypesDataSource {
    fun retrieveTypes(): Flow<List<Type>>
}