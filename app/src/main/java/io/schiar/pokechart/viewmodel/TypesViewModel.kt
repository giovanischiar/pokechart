package io.schiar.pokechart.viewmodel

import androidx.lifecycle.ViewModel
import io.schiar.pokechart.model.repository.TypesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update

class TypesViewModel(
    private val typesRepository: TypesRepository = TypesRepository()
): ViewModel() {
    val typesFlow = typesRepository.typesFlow.map { types -> types.toTypesViewData() }
    private val selectedTypesIndicesMutableStateFlow = MutableStateFlow(value = listOf<Int>())
    val selectedTypesIndicesStateFlow: StateFlow<List<Int>> = selectedTypesIndicesMutableStateFlow
    private val shouldNavigateToResultTypeMutableStateFlow = MutableStateFlow(value = false)
    val shouldNavigateToResultTypeStateFlow: StateFlow<Boolean>
        = shouldNavigateToResultTypeMutableStateFlow

    fun selectTypeAt(index: Int) {
        selectedTypesIndicesMutableStateFlow.update { selectedTypesIndices ->
            selectedTypesIndices.toMutableList().apply {
                if (selectedTypesIndices.contains(index)) remove(index) else add(index)
            }
        }
    }

    fun doneSelectingButtonWasPressed() {
        val selectedTypesIndices = selectedTypesIndicesMutableStateFlow.value
        if (selectedTypesIndices.isEmpty()) return
        typesRepository.addTypesToResultTypeTheTypesAt(indices = selectedTypesIndices)
        shouldNavigateToResultTypeMutableStateFlow.update { true }
    }
}