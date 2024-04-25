package io.schiar.pokechart.viewmodel

import androidx.lifecycle.ViewModel
import io.schiar.pokechart.model.repository.ResultTypeRepository
import kotlinx.coroutines.flow.map

class ResultTypeViewModel(
     currentTypesRepository: ResultTypeRepository = ResultTypeRepository()
): ViewModel() {
    val resultTypeFlow = currentTypesRepository.resultTypeFlow.map { types ->
        types.toViewData()
    }
}