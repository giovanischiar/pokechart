package io.schiar.pokechart.model.datasource

import io.schiar.pokechart.model.ResultType
import kotlinx.coroutines.flow.Flow

interface ResultTypeDataSource {
    fun retrieveResultType(): Flow<ResultType>
    fun updateResultType(resultType: ResultType)
}