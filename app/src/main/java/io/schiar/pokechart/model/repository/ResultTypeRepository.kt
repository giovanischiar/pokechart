package io.schiar.pokechart.model.repository

import io.schiar.pokechart.model.datasource.ResultTypeDataSource
import io.schiar.pokechart.model.datasource.local.ResultTypeLocalDataSource

class ResultTypeRepository(
    currentTypesDataSource: ResultTypeDataSource = ResultTypeLocalDataSource()
) {
    val resultTypeFlow = currentTypesDataSource.retrieveResultType()
}