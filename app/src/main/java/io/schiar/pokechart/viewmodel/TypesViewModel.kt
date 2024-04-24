package io.schiar.pokechart.viewmodel

import androidx.lifecycle.ViewModel
import io.schiar.pokechart.model.repository.TypesRepository
import kotlinx.coroutines.flow.map

class TypesViewModel(
    private val typesRepository: TypesRepository = TypesRepository()
): ViewModel() {
    val typesFlow = typesRepository.typesFlow.map { types -> types.toViewDataList() }

    fun addTypeToCurrentTypesTheTypeAt(vararg indices: Int) {
        typesRepository.addTypeToCurrentTypesTheTypeAt(*indices)
    }
}