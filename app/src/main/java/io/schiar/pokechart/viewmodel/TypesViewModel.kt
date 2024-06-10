package io.schiar.pokechart.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.schiar.pokechart.model.repository.TypesRepository
import io.schiar.pokechart.view.types.uistate.SelectedTypesIndicesUiState
import io.schiar.pokechart.view.types.uistate.TypeLayoutUiState
import io.schiar.pokechart.viewmodel.util.toTypeLayoutViewData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class TypesViewModel @Inject constructor(
    private val typesRepository: TypesRepository
): ViewModel() {
    val typeLayoutUiStateFlow = typesRepository.typesFlow
        .map { types -> TypeLayoutUiState.TypeLayoutLoaded(types.toTypeLayoutViewData()) }

    private val selectedTypesIndicesMutableStateFlow = MutableStateFlow(value = listOf<Int>())
    val selectedTypesIndicesUiStateStateFlow = selectedTypesIndicesMutableStateFlow
        .map { SelectedTypesIndicesUiState.SelectedTypesIndicesLoaded(it) }

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
        selectedTypesIndicesMutableStateFlow.update { emptyList() }
    }
}