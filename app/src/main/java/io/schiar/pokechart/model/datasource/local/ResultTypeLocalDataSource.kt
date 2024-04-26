package io.schiar.pokechart.model.datasource.local

import io.schiar.pokechart.model.Type
import io.schiar.pokechart.model.datasource.ResultTypeDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class ResultTypeLocalDataSource @Inject constructor(): ResultTypeDataSource {
    private var resultType: Type? = null
    private val resultTypeStateFlow = MutableStateFlow(resultType)

    override fun retrieveResultType(): Flow<Type> {
        return resultTypeStateFlow.filterNotNull()
    }

    override fun updateResultType(resultType: Type) {
        this.resultType = resultType
        resultTypeStateFlow.update { resultType }
    }
}