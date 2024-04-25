package io.schiar.pokechart.model.datasource

import io.schiar.pokechart.model.Type
import kotlinx.coroutines.flow.Flow

interface ResultTypeDataSource {
    fun retrieveResultType(): Flow<Type>
    fun updateResultType(resultType: Type)
}