package io.schiar.pokechart.viewmodel

import androidx.lifecycle.ViewModel
import io.schiar.pokechart.model.repository.CurrentTypesRepository
import kotlinx.coroutines.flow.map

class CurrentTypesViewModel(
     currentTypesRepository: CurrentTypesRepository = CurrentTypesRepository()
): ViewModel() {
    val currentTypesFlow = currentTypesRepository.currentTypesFlow.map { types ->
        types.toViewDataList()
    }
}