package io.schiar.pokechart.model.repository

import io.schiar.pokechart.model.datasource.ResultTypeDataSource
import javax.inject.Inject

class ResultTypeRepository @Inject constructor(
    currentTypesDataSource: ResultTypeDataSource
) {
    val resultTypeFlow = currentTypesDataSource.retrieveResultType()
}