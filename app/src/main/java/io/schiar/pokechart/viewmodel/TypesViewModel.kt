package io.schiar.pokechart.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.schiar.pokechart.model.repository.TypesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class TypesViewModel @Inject constructor(
    private val typesRepository: TypesRepository
): ViewModel() {
    val typesFlow = typesRepository.typesFlow.map { types -> types.toTypesViewData() }
    private val selectedTypesIndicesMutableStateFlow = MutableStateFlow(value = listOf<Int>())
    val selectedTypesIndicesStateFlow: StateFlow<List<Int>> = selectedTypesIndicesMutableStateFlow
    private val shouldNavigateMutableStateFlow = MutableStateFlow(value = false)
    val shouldNavigateStateFlow: StateFlow<Boolean> = shouldNavigateMutableStateFlow

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
        shouldNavigateMutableStateFlow.update { true }
    }

    fun navigationInitiated() {
        shouldNavigateMutableStateFlow.update { false }
        selectedTypesIndicesMutableStateFlow.update { emptyList() }
    }
}