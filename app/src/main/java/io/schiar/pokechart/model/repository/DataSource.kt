package io.schiar.pokechart.model.repository

import io.schiar.pokechart.model.Type

interface DataSource {
    fun loadTypes(): List<Type>
}