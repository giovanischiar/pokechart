package io.schiar.pokechart.library.hilt

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.schiar.pokechart.model.datasource.ResultTypeDataSource
import io.schiar.pokechart.model.datasource.TypesDataSource
import io.schiar.pokechart.model.datasource.local.ResultTypeLocalDataSource
import io.schiar.pokechart.model.datasource.local.TypesLocalDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceBinder {
    @Singleton
    @Binds
    fun bindResultTypeDataSource(
        resultTypeLocalDataSource: ResultTypeLocalDataSource
    ): ResultTypeDataSource

    @Binds
    fun bindTypesDataSource(typeLocalDataSource: TypesLocalDataSource): TypesDataSource
}