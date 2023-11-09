package io.schiar.pokechart.model.repository

import io.schiar.pokechart.model.Type

interface Repository {
    val types: List<Type>
    val currentTypes: List<Type>

    fun addCurrentType(typeName: String)
}