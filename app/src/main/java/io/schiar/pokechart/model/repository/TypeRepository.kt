package io.schiar.pokechart.model.repository

import io.schiar.pokechart.model.Type

class TypeRepository(private val dataSource: DataSource = TypeDataSource()) : Repository {
    override val types: List<Type>
        get() = dataSource.loadTypes()
}